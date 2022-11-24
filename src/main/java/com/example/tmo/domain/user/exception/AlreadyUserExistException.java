package com.example.tmo.domain.user.exception;

import com.example.tmo.global.error.ErrorCode;
import com.example.tmo.global.error.handler.TmoException;

public class AlreadyUserExistException extends TmoException {

    public static final TmoException EXCEPTION = new AlreadyUserExistException();

    private AlreadyUserExistException() {
        super(ErrorCode.ALREADY_USER_EXIST);
    }
}
