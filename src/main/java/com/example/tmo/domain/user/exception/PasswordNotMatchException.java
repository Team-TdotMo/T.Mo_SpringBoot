package com.example.tmo.domain.user.exception;

import com.example.tmo.global.error.ErrorCode;
import com.example.tmo.global.error.handler.TmoException;

public class PasswordNotMatchException extends TmoException {

    public static final TmoException EXCEPTION = new PasswordNotMatchException();

    private PasswordNotMatchException() {
        super(ErrorCode.PASSWORD_NOT_MATCH);
    }
}
