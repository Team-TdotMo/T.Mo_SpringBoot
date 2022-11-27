package com.example.tmo.domain.recruitment.exception;

import com.example.tmo.global.error.ErrorCode;
import com.example.tmo.global.error.handler.TmoException;

public class RecruitmentNotFoundException extends TmoException {

    public static final TmoException EXCEPTION = new RecruitmentNotFoundException();

    private RecruitmentNotFoundException() {
        super(ErrorCode.RECRUITMENT_NOT_FOUND);
    }
}
