package com.example.tmo.domain.recruitment.exception;

import com.example.tmo.global.error.ErrorCode;
import com.example.tmo.global.error.handler.TmoException;

public class RecruitmentNotDeleteException extends TmoException {

    public static final TmoException EXCEPTION = new RecruitmentNotDeleteException();

    private RecruitmentNotDeleteException() {
        super(ErrorCode.RECRUITMENT_NOT_DELETE);
    }
}
