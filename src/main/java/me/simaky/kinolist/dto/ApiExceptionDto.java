package me.simaky.kinolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiExceptionDto {
    private int statusCode;
    private String message;
    private String timestamp;
}
