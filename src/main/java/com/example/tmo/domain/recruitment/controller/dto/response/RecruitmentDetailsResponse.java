package com.example.tmo.domain.recruitment.controller.dto.response;

import com.example.tmo.domain.image.domain.RecruitmentImage;
import com.example.tmo.domain.recruitment.domain.type.MajorType;
import com.example.tmo.domain.recruitment.domain.type.RecruitmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class RecruitmentDetailsResponse {

    private final MajorType majorType;
    private final RecruitmentType recruitmentType;
    private final String technology;
    private final LocalDate period;
    private final String content;
    private final List<String> imagePaths;
    private final List<String> category;
}
