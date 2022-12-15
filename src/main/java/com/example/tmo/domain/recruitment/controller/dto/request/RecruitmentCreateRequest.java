package com.example.tmo.domain.recruitment.controller.dto.request;

import com.example.tmo.domain.recruitment.domain.type.RecruitmentType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@NoArgsConstructor
public class RecruitmentCreateRequest {

    private RecruitmentType recruitmentType;

    @NotNull(message = "내용을 입력해주세요.")
    @Size(min = 10, max = 4000)
    private String content;

    @NotNull(message = "제목을 입력해주세요.")
    @Size(min = 5, max = 60)
    private String title;

    @NotNull(message = "모집인원을 입력해주세요.")
    @Min(value = 1, message = "모집인원은 0명을 초과해야합니다.")
    private Integer number;

    @NotNull(message = "모집기간을 입력해주세요.")
    private Date period;
}
