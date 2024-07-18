package by.digitalchief.library.exception;

import by.digitalchief.library.dto.ExceptionResponseDto;
import by.digitalchief.library.dto.ValidationExceptionResponseDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ValidationExceptionResponseDto handleBindExceptions(BindException e) {
        return new ValidationExceptionResponseDto(
                new Date(System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST,
                "Validation Error!",
                getFieldErrors(e));
    }

    private Map<String, String> getFieldErrors(BindException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });
        return fieldErrors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageConversionException.class)
    ExceptionResponseDto handleHttpMessageConversionException(HttpMessageConversionException e) {
        String message = e.getMessage();
        return new ExceptionResponseDto(
                new Date(System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST,
                e.getMessage().substring(message.indexOf("Text"))
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    ExceptionResponseDto handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return new ExceptionResponseDto(
                new Date(System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST,
                e.getMessage()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    ExceptionResponseDto handleNoSuchElementException(NoSuchElementException e) {
        return new ExceptionResponseDto(
                new Date(System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST,
                e.getMessage()
        );
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    ExceptionResponseDto handleAllExceptions(Exception e) {
        return new ExceptionResponseDto(
                new Date(System.currentTimeMillis()),
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage());
    }

}
