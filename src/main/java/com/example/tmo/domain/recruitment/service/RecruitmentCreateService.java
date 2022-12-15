package com.example.tmo.domain.recruitment.service;

import com.example.tmo.domain.recruitment.controller.dto.request.RecruitmentCreateRequest;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RecruitmentCreateService {

    private final RecruitmentRepository recruitmentRepository;
    private final UserFacade userFacade;

    @Transactional
    public Long execute(RecruitmentCreateRequest request) {

        User user = userFacade.getCurrentUser();

        Recruitment recruitment = recruitmentRepository.save(Recruitment.builder()
                .title(request.getTitle())
<<<<<<< Updated upstream
                .majorType(request.getMajorType())
                .technology(request.getTechnology())
=======
>>>>>>> Stashed changes
                .recruitmentType(request.getRecruitmentType())
                .content(request.getContent())
                .period(request.getPeriod())
                .number(request.getNumber())
                .user(user)
                .build());

        return recruitment.getId();
    }
}
