package me.simaky.kinolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
public class ApiExceptionDto {
    private int statusCode;
    private String message;
    private String timestamp;

    public static String getTimeNow() {
        return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
    }
}
