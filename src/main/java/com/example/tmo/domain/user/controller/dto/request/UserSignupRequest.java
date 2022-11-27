package com.example.tmo.domain.user.controller.dto.request;

import com.example.tmo.domain.recruitment.domain.type.MajorType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserSignupRequest {

    @NotNull(message = "이름을 입력해주세요.")
    private String name;

    @NotNull(message = "학년을 입력해주세요")
    private int grade;

    @NotNull(message = "이메일을 입력해주세요.")
    private String email;

    @NotNull(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자로 작성해주세요.")
    private String password;

    @NotNull
    private MajorType majorType;
}
