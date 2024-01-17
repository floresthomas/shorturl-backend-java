package com.thomas.shorturl.service;

import com.thomas.shorturl.dto.UrlDto;
import com.thomas.shorturl.model.Url;

public interface IUrlService {

    public Url generateShortLink(UrlDto urlDto);

    public Url persistShortLink(Url url);

    public Url getEncodedUrl(String url);

    public void deleteShortLink(Url url);
}
