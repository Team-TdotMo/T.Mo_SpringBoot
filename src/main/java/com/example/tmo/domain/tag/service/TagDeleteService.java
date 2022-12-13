package com.example.tmo.domain.tag.service;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.facade.RecruitmentFacade;
import com.example.tmo.domain.tag.domain.repository.TagRepository;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TagDeleteService {

    private final RecruitmentFacade recruitmentFacade;
    private final UserFacade userFacade;
    private final TagRepository tagRepository;

    @Transactional
    public void execute(Long recruitmentId) {

        User user = userFacade.getCurrentUser();
        Recruitment recruitment = recruitmentFacade.findByRecruitmentId(recruitmentId);
        recruitmentFacade.checkWriter(recruitment);

        tagRepository.deleteByRecruitmentId(recruitmentId);
    }
}
