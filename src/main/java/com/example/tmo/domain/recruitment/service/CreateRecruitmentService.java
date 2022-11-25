package com.example.tmo.domain.recruitment.service;

import com.example.tmo.domain.recruitment.controller.dto.request.CreateRecruitmentRequest;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateRecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createRecruitment(CreateRecruitmentRequest request) {

        User user = userFacade.getCurrentUser();

        recruitmentRepository.save(Recruitment.builder()
                .title(request.getTitle())
                .majorType(request.getMajorType())
                .technology(request.getTechnology())
                .recruitmentType(request.getRecruitmentType())
                .content(request.getContent())
                .user(user)
                .build()
        );
    }
}
