package com.example.tmo.domain.user.exception;

import com.example.tmo.global.error.ErrorCode;
import com.example.tmo.global.error.handler.TmoException;

public class UserNotFoundException extends TmoException {

    public static final TmoException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
