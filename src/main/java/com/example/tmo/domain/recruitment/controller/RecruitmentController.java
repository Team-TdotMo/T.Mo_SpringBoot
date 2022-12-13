package com.example.tmo.domain.recruitment.controller;

import com.example.tmo.domain.recruitment.controller.dto.request.RecruitmentCreateRequest;
import com.example.tmo.domain.recruitment.controller.dto.request.RecruitmentUpdateRequest;
import com.example.tmo.domain.recruitment.controller.dto.response.RecruitmentDetailsResponse;
import com.example.tmo.domain.recruitment.controller.dto.response.RecruitmentIdResponse;
import com.example.tmo.domain.recruitment.service.RecruitmentCreateService;
import com.example.tmo.domain.recruitment.service.RecruitmentDeleteService;
import com.example.tmo.domain.recruitment.service.RecruitmentDetailsService;
import com.example.tmo.domain.recruitment.service.RecruitmentUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    private final RecruitmentCreateService createRecruitmentService;
    private final RecruitmentDetailsService recruitmentDetailsService;
    private final RecruitmentDeleteService recruitmentDeleteService;
    private final RecruitmentUpdateService recruitmentUpdateService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/write")
    public Long createRecruitment(@RequestBody @Valid RecruitmentCreateRequest request) {
        return createRecruitmentService.execute(request);
    }

    @GetMapping("/{id}")
    public RecruitmentDetailsResponse DetailsRecruitment(@PathVariable("id") Long recruitmentId) {
        return recruitmentDetailsService.execute(recruitmentId);
    }

    @DeleteMapping("/{id}")
    public void deleteRecruitment(@PathVariable("id") Long recruitmentId) {
        recruitmentDeleteService.execute(recruitmentId);
    }

    @PatchMapping("/{id}")
    public void updateRecruitment(@PathVariable("id") Long recruitmentId, @RequestBody @Valid RecruitmentUpdateRequest request) {
        recruitmentUpdateService.execute(recruitmentId, request);
    }
}
