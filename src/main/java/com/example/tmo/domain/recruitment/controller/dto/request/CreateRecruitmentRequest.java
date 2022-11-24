package com.example.tmo.domain.recruitment.controller.dto.request;

import com.example.tmo.domain.recruitment.domain.type.Category;
import com.example.tmo.domain.recruitment.domain.type.MajorCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateRecruitmentRequest {

    @NotNull
    private MajorCategory majorCategory;

    @NotNull
    private Category category;

    @NotNull(message = "모집 분야를 작성해주세요.")
    private String technology;

    @NotNull(message = "내용을 입력해주세요.")
    @Size(min = 10, max = 4000)
    private String content;

    @NotNull(message = "제목을 입력해주세요.")
    @Size(min = 5, max = 60)
    private String title;
}
