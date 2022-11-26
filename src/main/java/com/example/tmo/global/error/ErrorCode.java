package com.example.tmo.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    FILE_IS_EMPTY(400, "파일이 비어있습니다."),
    FILE_SAVE_FAILED(400, "파일 저장을 실패했습니다."),

    EXPIRED_JWT(401, "토큰이 만료되었습니다."),
    INVALID_JWT(401, "토큰이 유효하지 않습니다."),
    PASSWORD_NOT_MATCH(401, "비밀번호가 일치하지 않습니다."),

    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),
    RECRUITMENT_NOT_FOUND(404, "모집글을 찾을 수 없습니다."),

    ALREADY_USER_EXIST(409, "이미 존재하는 유저 입니다."),
    INTERNAL_SERVER_ERROR(500, "서버 오류입니다.");

    private final int status;
    private final String message;
}
