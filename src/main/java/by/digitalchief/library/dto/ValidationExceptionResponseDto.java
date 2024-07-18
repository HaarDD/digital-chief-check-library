package by.digitalchief.library.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Map;

@Getter
public class ValidationExceptionResponseDto extends ExceptionResponseDto{

    private final Map<String, String> fieldErrors;

    public ValidationExceptionResponseDto(Date timestamp, HttpStatus status, String message, Map<String, String> fieldErrors) {
        super(timestamp, status, message);
        this.fieldErrors = fieldErrors;
    }
}
