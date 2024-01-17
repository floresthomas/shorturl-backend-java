package com.thomas.shorturl.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlResponseDto {

    private String originalUrl;
    private String shortLink;
    private LocalDateTime expirationLink;

    public UrlResponseDto() {
    }

    public UrlResponseDto(String originalUrl, String shortLink, LocalDateTime expirationLink) {
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
        this.expirationLink = expirationLink;
    }

    @Override
    public String toString() {
        return "UrlResponseDto{" + "originalUrl=" + originalUrl + ", shortLink=" + shortLink + ", expirationLink=" + expirationLink + '}';
    }

}
