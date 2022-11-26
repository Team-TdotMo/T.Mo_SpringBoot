package com.example.tmo.domain.recruitment.controller.dto.request;

import com.example.tmo.domain.recruitment.domain.type.MajorType;
import com.example.tmo.domain.recruitment.domain.type.RecruitmentType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CreateRecruitmentRequest {

    private MajorType majorType;

    private RecruitmentType recruitmentType;

    @NotNull(message = "모집 분야를 작성해주세요.")
    private String technology;

    @NotNull(message = "내용을 입력해주세요.")
    @Size(min = 10, max = 4000)
    private String content;

    @NotNull(message = "제목을 입력해주세요.")
    @Size(min = 5, max = 60)
    private String title;

    @NotNull(message = "모집기간을 입력해주세요.")
    private LocalDate period;
}
