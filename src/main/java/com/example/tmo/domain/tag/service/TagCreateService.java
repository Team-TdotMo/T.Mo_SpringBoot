package com.example.tmo.domain.tag.service;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.facade.RecruitmentFacade;
import com.example.tmo.domain.tag.controller.dto.request.TagCreateRequest;
import com.example.tmo.domain.tag.domain.Tag;
import com.example.tmo.domain.tag.domain.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagCreateService {

    private final RecruitmentFacade recruitmentFacade;
    private final TagRepository tagRepository;

    @Transactional
    public void execute(Long recruitmentId, TagCreateRequest request) {

        Recruitment recruitment = recruitmentFacade.findByRecruitmentId(recruitmentId);

        tagRepository.save(Tag.builder()
<<<<<<< HEAD
                .category(request.getType())
=======
                .category(request.getCategory())
>>>>>>> 28a8925efc5acd75c196971d13f277e093b6f508
                .recruitment(recruitment)
                .build());
    }
}
