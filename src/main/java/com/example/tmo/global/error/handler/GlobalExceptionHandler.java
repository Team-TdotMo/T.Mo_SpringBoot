package com.example.tmo.global.error.handler;

import com.example.tmo.global.error.ErrorCode;
import com.example.tmo.global.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 예외처리 + 응답 : @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(TmoException.class)
    public ResponseEntity<ErrorResponse> customExceptionHandling(TmoException e) {

        final ErrorCode errorCode = e.getErrorCode();

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build(),
                HttpStatus.valueOf(errorCode.getStatus())
        );
    }
}
