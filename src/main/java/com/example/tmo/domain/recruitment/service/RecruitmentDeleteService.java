package com.example.tmo.domain.recruitment.service;

import com.example.tmo.domain.image.domain.repository.RecruitmentImageRepository;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.tmo.domain.recruitment.facade.RecruitmentFacade;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class RecruitmentDeleteService {

    private final RecruitmentRepository recruitmentRepository;
    private final RecruitmentImageRepository recruitmentImageRepository;
    private final RecruitmentFacade recruitmentFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long recruitmentId) {

        User user = userFacade.getCurrentUser();
        Recruitment recruitment = recruitmentFacade.findByRecruitmentId(recruitmentId);
        recruitmentFacade.checkWriter(recruitment);

        recruitmentRepository.delete(recruitment);
        recruitmentImageRepository.deleteAllByIdInBatch(Collections.singleton(recruitmentId));
    }
}
