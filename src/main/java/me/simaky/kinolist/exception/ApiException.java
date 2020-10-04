package me.simaky.kinolist.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiException extends RuntimeException {
    private int statusCode;
    private String message;
}
