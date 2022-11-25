package com.example.tmo.domain.recruitment.controller;

import com.example.tmo.domain.recruitment.controller.dto.request.CreateRecruitmentRequest;
import com.example.tmo.domain.recruitment.controller.dto.response.RecruitmentDetailsResponse;
import com.example.tmo.domain.recruitment.service.CreateRecruitmentService;
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
@RequestMapping("/recruitment")
@RestController
public class RecruitmentController {

    private final CreateRecruitmentService createRecruitmentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/writer")
    public void createRecruitment(@RequestBody @Valid CreateRecruitmentRequest request) {
        createRecruitmentService.createRecruitment(request);
    }

    @GetMapping("{id}")
    public RecruitmentDetailsResponse recruitmentDetails(@PathVariable("id") Long recruitmentId) {

    }
}
