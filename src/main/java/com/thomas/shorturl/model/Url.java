package com.thomas.shorturl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Url {

    @Id
    @GeneratedValue
    private long id;

    private String originalUrl;
    private String shortLink;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;

    public Url() {
    }

    public Url(long id, String originalUrl, String shortLink, LocalDateTime creationDate, LocalDateTime expirationDate) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Url{" + "id=" + id + ", originalUrl=" + originalUrl + ", shortLink=" + shortLink + ", creationDate=" + creationDate + ", expirationDate=" + expirationDate + '}';
    }

}
