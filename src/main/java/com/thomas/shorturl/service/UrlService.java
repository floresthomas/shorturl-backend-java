package com.thomas.shorturl.service;

import com.google.common.hash.Hashing;
import com.thomas.shorturl.dto.UrlDto;
import com.thomas.shorturl.model.Url;
import com.thomas.shorturl.repository.IUrlRepository;
import io.micrometer.common.util.StringUtils;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService implements IUrlService {

    @Autowired
    private IUrlRepository urlRepository;

    @Override
    public Url generateShortLink(UrlDto urlDto) {
        if (StringUtils.isNotEmpty(urlDto.getUrl())) {
            String encodedUrl = encodeUrl(urlDto.getUrl());
            Url urlToPersist = new Url();
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setOriginalUrl(urlDto.getUrl());
            urlToPersist.setShortLink(encodedUrl);
            urlToPersist.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(), urlToPersist.getCreationDate()));
            Url urlToRet = persistShortLink(urlToPersist);

            if (urlToRet != null) {
                return urlToRet;
            }
            return null;

        }
        return null;
    }

    @Override
    public Url persistShortLink(Url url) {
        Url urlToRet = urlRepository.save(url);
        return urlToRet;
    }

    @Override
    public Url getEncodedUrl(String url) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteShortLink(Url url) {
        urlRepository.delete(url);
    }

    private String encodeUrl(String url) {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        return encodedUrl;
    }

    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
        if (StringUtils.isBlank(expirationDate)) {
            return creationDate.plusSeconds(120);
        }
        LocalDateTime expirationDateToRet = LocalDateTime.parse(expirationDate);
        return expirationDateToRet;
    }
}
