package com.example.tmo.domain.recruitment.service;

import com.example.tmo.domain.image.domain.repository.RecruitmentImageRepository;
import com.example.tmo.domain.recruitment.controller.dto.response.RecruitmentDetailsResponse;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RecruitmentDetailsService {

    private final RecruitmentImageRepository recruitmentRepository;
    private final UserFacade userFacade;
    private final RecruitmentImageRepository recruitmentImageRepository;

    public RecruitmentDetailsResponse getRecruitmentDetails(Long recruitmentId) {
        Recruitment recruitment =
    }
}
