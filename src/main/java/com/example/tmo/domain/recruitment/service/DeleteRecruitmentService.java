package com.example.tmo.domain.recruitment.service;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.tmo.domain.recruitment.exception.RecruitmentNotDeleteException;
import com.example.tmo.domain.recruitment.facade.RecruitmentFacade;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteRecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final RecruitmentFacade recruitmentFacade;
    private final UserFacade userFacade;

    @Transactional
    public void deleteRecruitment(Long recruitmentId) {

        User user = userFacade.getCurrentUser();
        Recruitment recruitment = recruitmentFacade.findByRecruitmentId(recruitmentId);

        if(!user.equals(recruitment.getUser())) {
            throw RecruitmentNotDeleteException.EXCEPTION;
        }

        recruitmentRepository.delete(recruitment);
    }
}
