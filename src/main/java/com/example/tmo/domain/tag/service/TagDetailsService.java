package com.example.tmo.domain.tag.service;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.facade.RecruitmentFacade;
import com.example.tmo.domain.tag.controller.dto.response.TagDetailsResponse;
import com.example.tmo.domain.tag.domain.Tag;
import com.example.tmo.domain.tag.domain.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class TagDetailsService {

    private final RecruitmentFacade recruitmentFacade;
    private final TagRepository tagRepository;

    @Transactional
    public List<TagDetailsResponse> execute(Long recruitmentId) {
        Recruitment recruitment = recruitmentFacade.findByRecruitmentId(recruitmentId);
        List<Tag> categoryList = tagRepository.findAllByRecruitment(recruitment);

        Stream<Tag> stream = categoryList.stream();

        return stream.map(TagDetailsResponse::categoryList).collect(Collectors.toList());
    }

}
