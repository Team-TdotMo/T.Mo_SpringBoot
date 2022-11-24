package com.example.tmo.domain.user.controller.dto.request;

import com.example.tmo.domain.recruitment.domain.type.MajorCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserSignupRequest {

    @NotBlank(message = "이름을 입력해주세요.")
    private String Name;

    @NotBlank(message = "학년을 입력해주세요")
    private int grade;

    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자로 작성해주세오.")

    private String password;

    @NotBlank
    private MajorCategory majorCategory;
}