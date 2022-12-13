package com.example.tmo.domain.user.service;

import com.example.tmo.domain.user.controller.dto.request.UserLoginRequest;
import com.example.tmo.domain.user.controller.dto.request.UserSignupRequest;
import com.example.tmo.domain.user.controller.dto.response.MemberInfoResponse;
import com.example.tmo.domain.user.controller.dto.response.TokenResponse;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.domain.repository.UserRepository;
import com.example.tmo.domain.user.exception.UserNotFoundException;
import com.example.tmo.domain.user.facade.UserFacade;
import com.example.tmo.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void signup(UserSignupRequest request) {

        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserNotFoundException.EXCEPTION;
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .grade(request.getGrade())
                .MajorType(request.getMajorType())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
    }

    @Transactional
    public TokenResponse login(UserLoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                        .orElseThrow(()->UserNotFoundException.EXCEPTION);

        userFacade.checkPassword(user, request.getPassword());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateToken(request.getEmail()))
                .build();
    }

    @Transactional
    public MemberInfoResponse memberInfo(Long id){
        User user = userFacade.getMemberInfo(id);

        return MemberInfoResponse.builder()
                .name(user.getName())
                .grade(user.getGrade())
                .majorType(user.getMajorType())
                .star(user.getStar())
                .technology(user.getTechnology())
                .introduce(user.getIntroduce())
                .project(user.getProject())
                .myProject(user.getMyProject())
                .content(user.getContent())
                .build();
    }
}