package me.simaky.kinolist.controller.advice;

import me.simaky.kinolist.dto.ApiExceptionDto;
import me.simaky.kinolist.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class ApiControllerAdvice {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<Object> handleException(ApiException apiException) {
        ApiExceptionDto apiExceptionDto = new ApiExceptionDto(
                apiException.getStatusCode(),
                apiException.getMessage(),
                new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date())
        );

        return ResponseEntity.status(apiException.getStatusCode()).body(apiExceptionDto);
    }
}
