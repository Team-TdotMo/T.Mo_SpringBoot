package com.example.tmo.global.exception;

import com.example.tmo.global.error.ErrorCode;
import com.example.tmo.global.error.handler.TmoException;

public class FileIsEmptyException extends TmoException {

    public static final TmoException EXCEPTION = new FileIsEmptyException();

    private FileIsEmptyException() {
        super(ErrorCode.FILE_IS_EMPTY);
    }
}
