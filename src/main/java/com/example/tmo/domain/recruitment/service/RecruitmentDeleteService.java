package com.example.tmo.domain.recruitment.service;

import com.example.tmo.domain.image.domain.Image;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.tmo.domain.recruitment.facade.RecruitmentFacade;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.facade.UserFacade;
import com.example.tmo.global.image.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class RecruitmentDeleteService {

    private final RecruitmentRepository recruitmentRepository;
    private final RecruitmentFacade recruitmentFacade;
    private final UserFacade userFacade;
    private final S3Facade s3Facade;

    @Transactional
    public void execute(Long recruitmentId) {

        User user = userFacade.getCurrentUser();
        Recruitment recruitment = recruitmentFacade.findByRecruitmentId(recruitmentId);
        recruitmentFacade.checkWriter(recruitment);

        for(Image recruitmentImage : recruitment.getRecruitmentImage()) {
            s3Facade.delete(recruitmentImage.getImagePath());
        }

        recruitmentRepository.delete(recruitment);
    }
}
