package com.example.tmo.domain.applicant.controller;

import com.example.tmo.domain.applicant.service.ApplicantCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/applicant")
@RestController
public class ApplicantController {

    private final ApplicantCreateService applicantCreateService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public void createApplicant(@PathVariable("id") Long recruitmentId) {
        applicantCreateService.execute(recruitmentId);
    }
}
