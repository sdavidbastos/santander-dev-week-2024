package com.david.sdw24.adapters.in.exception;

import com.david.sdw24.domain.exceptions.ChampionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ChampionNotFoundException.class)
    public ResponseEntity<ApiError> handleDomainException(ChampionNotFoundException domainError){
        return ResponseEntity
                .unprocessableEntity()
                .body(new ApiError(domainError.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception unexpectedError){
        String message="Ops... Algo deu errado :/";
        logger.error(message, unexpectedError);
        return ResponseEntity
                .internalServerError()
                .body(new ApiError(message));
    }

    public record ApiError(String message){}
}
