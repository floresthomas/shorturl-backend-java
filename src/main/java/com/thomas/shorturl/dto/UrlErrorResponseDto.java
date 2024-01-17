package com.thomas.shorturl.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlErrorResponseDto {

    private String status;
    private String error;

    public UrlErrorResponseDto() {
    }

    public UrlErrorResponseDto(String status, String error) {
        this.status = status;
        this.error = error;
    }

    @Override
    public String toString() {
        return "UrlErrorResponseDto{" + "status=" + status + ", error=" + error + '}';
    }

}
