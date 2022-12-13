package com.example.tmo.domain.user.controller;

import com.example.tmo.domain.user.controller.dto.request.UserLoginRequest;
import com.example.tmo.domain.user.controller.dto.request.UserSignupRequest;
import com.example.tmo.domain.user.controller.dto.response.MemberInfoResponse;
import com.example.tmo.domain.user.controller.dto.response.TokenResponse;
import com.example.tmo.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignupRequest request) {
        userService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/member/{id}")
    public MemberInfoResponse memberInfo(@PathVariable("id") Long id) {
        return userService.memberInfo(id);
    }
}
