package com.example.tmo.domain.recruitment.exception;

import com.example.tmo.global.error.ErrorCode;
import com.example.tmo.global.error.handler.TmoException;

public class RecruitmentNotUpdateException extends TmoException {

    public static final TmoException EXCEPTION = new RecruitmentNotUpdateException();

    private RecruitmentNotUpdateException() {
        super(ErrorCode.RECRUITMENT_NOT_UPDATE);
    }
}
