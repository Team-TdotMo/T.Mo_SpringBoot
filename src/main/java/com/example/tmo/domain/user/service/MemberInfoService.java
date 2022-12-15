package com.example.tmo.domain.user.service;

import com.example.tmo.domain.user.controller.dto.response.MemberInfoResponse;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberInfoService {
    private final UserFacade userFacade;

    @Transactional
    public MemberInfoResponse execute(Long id){
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
