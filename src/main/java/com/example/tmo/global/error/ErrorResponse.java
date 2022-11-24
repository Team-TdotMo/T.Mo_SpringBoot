package com.example.tmo.global.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
public class ErrorResponse {

    private final int status;
    private final String message;
}
