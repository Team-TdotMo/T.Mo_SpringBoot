package com.example.tmo.domain.recruitment.facade;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.tmo.domain.recruitment.exception.RecruitmentNotFoundException;
import com.example.tmo.domain.recruitment.exception.RecruitmentNotUpdateException;
import com.example.tmo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RecruitmentFacade {

    private final RecruitmentRepository recruitmentRepository;
    private final UserFacade userFacade;

    public Recruitment findByRecruitmentId (Long recruitmentId) {
        return recruitmentRepository.findById(recruitmentId)
                .orElseThrow(()-> RecruitmentNotFoundException.EXCEPTION);
    }

    public void checkWriter(Recruitment recruitment) {
        if(!userFacade.getCurrentUser().equals(recruitment.getUser()))
            throw RecruitmentNotUpdateException.EXCEPTION;
    }
}
