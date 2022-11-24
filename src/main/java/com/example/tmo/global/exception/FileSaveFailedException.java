package com.example.tmo.global.exception;

import com.example.tmo.global.error.ErrorCode;
import com.example.tmo.global.error.handler.TmoException;

public class FileSaveFailedException extends TmoException {

    public static final TmoException EXCEPTION = new FileSaveFailedException();

    private FileSaveFailedException() {
        super(ErrorCode.FILE_SAVE_FAILED);
    }
}
