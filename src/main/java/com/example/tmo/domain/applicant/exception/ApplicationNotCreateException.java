package com.example.tmo.domain.applicant.exception;

import com.example.tmo.global.error.ErrorCode;
import com.example.tmo.global.error.handler.TmoException;

public class ApplicationNotCreateException extends TmoException {

    public static final TmoException EXCEPTION = new ApplicationNotCreateException();

    private ApplicationNotCreateException() {
        super(ErrorCode.APPLICATION_NOT_CREATE);
    }
}
