package com.example.tmo.domain.recruitment.service;

import com.example.tmo.domain.image.domain.RecruitmentImage;
import com.example.tmo.domain.image.domain.repository.RecruitmentImageRepository;
import com.example.tmo.domain.recruitment.controller.dto.response.RecruitmentDetailsResponse;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.facade.RecruitmentFacade;
import com.example.tmo.domain.tag.domain.repository.TagRepository;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.facade.UserFacade;
import com.example.tmo.global.image.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecruitmentDetailsService {
    private final UserFacade userFacade;
    private final S3Facade s3Facade;
    private final RecruitmentFacade recruitmentFacade;
    private final RecruitmentImageRepository recruitmentImageRepository;
    private final TagRepository tagRepository;

    public RecruitmentDetailsResponse execute(Long recruitmentId) {

        Recruitment recruitment = recruitmentFacade.findByRecruitmentId(recruitmentId);
        User user = userFacade.getCurrentUser();

        List<RecruitmentImage> recruitmentImages = recruitmentImageRepository.findAllByRecruitment(recruitment);

        return RecruitmentDetailsResponse.builder()
                .content(recruitment.getContent())
                .recruitmentType(recruitment.getRecruitmentType())
                .imagePaths(recruitmentImages.stream()
                        .map(recruitmentImage -> s3Facade.getImageUrl(recruitmentImage.getImagePath()))
                        .collect(Collectors.toList()))
                .period(recruitment.getPeriod())
                .technology(recruitment.getTechnology())
                .build();
    }
}
