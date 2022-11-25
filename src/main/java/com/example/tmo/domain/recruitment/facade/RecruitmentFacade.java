package com.example.tmo.domain.recruitment.facade;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.domain.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RecruitmentFacade {

    private final RecruitmentRepository recruitmentRepository;

    public Recruitment findByRecruitmentId (Long RecruitmentId) {
        return
    }
}
