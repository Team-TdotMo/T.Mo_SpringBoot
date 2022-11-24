package com.example.tmo.global.error.handler;

import com.example.tmo.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TmoException extends RuntimeException {
    private final ErrorCode errorCode;
}
