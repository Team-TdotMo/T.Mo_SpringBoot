package com.example.tmo.domain.applicant.service;

import com.example.tmo.domain.applicant.domain.Applicant;
import com.example.tmo.domain.applicant.domain.repository.ApplicantRepository;
import com.example.tmo.domain.applicant.exception.ApplicationNotCreateException;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.facade.RecruitmentFacade;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ApplicantCreateService {

    private final UserFacade userFacade;
    private final RecruitmentFacade recruitmentFacade;
    private final ApplicantRepository applicantRepository;

    @Transactional
    public void execute(Long recruitmentId) {

        Long user = userFacade.getUserId();
        Recruitment recruitment = recruitmentFacade.findByRecruitmentId(recruitmentId);

        if(recruitment.getUser().equals(user)) {
            throw ApplicationNotCreateException.EXCEPTION;
        }

        applicantRepository.save(Applicant.builder()
                .user(user)
                .recruitment(recruitment)
                .build());

    }
}
