package com.example.tmo.domain.recruitment.service;

import com.example.tmo.domain.recruitment.controller.dto.request.RecruitmentUpdateRequest;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.facade.RecruitmentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RecruitmentUpdateService {

    private final RecruitmentFacade recruitmentFacade;

    @Transactional
    public void execute(Long recruitmentId, RecruitmentUpdateRequest request) {

        Recruitment recruitment = recruitmentFacade.findByRecruitmentId(recruitmentId);
<<<<<<< HEAD
        recruitmentFacade.checkWriter(recruitment);

        recruitment.updateRecruitment(request.getNumber(), request.getTitle(),  request.getPeriod(), request.getContent(), request.getTechnology(),
               request.getRecruitmentType());
=======
        recruitmentFacade.checkUser(recruitment);

        recruitment.updateRecruitment(request.getTitle(),  request.getPeriod(), request.getContent(), request.getTechnology(),
               request.getRecruitmentType(), request.getMajorType());
>>>>>>> main
    }
}