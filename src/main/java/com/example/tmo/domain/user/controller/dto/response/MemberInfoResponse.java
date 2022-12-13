package com.example.tmo.domain.user.controller.dto.response;

import com.example.tmo.domain.recruitment.domain.type.MajorType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberInfoResponse {
    private String name;
    private Integer grade;
    private final MajorType majorType;
    private String technology;
    private Integer star;
    private String content;
    private String introduce;
    private String project;
    private String myProject;
}
