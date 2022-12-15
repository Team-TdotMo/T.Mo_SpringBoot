package com.example.tmo.domain.tag.controller;

import com.example.tmo.domain.tag.controller.dto.request.TagCreateRequest;
import com.example.tmo.domain.tag.controller.dto.response.TagDetailsResponse;
import com.example.tmo.domain.tag.service.TagCreateService;
import com.example.tmo.domain.tag.service.TagDeleteService;
import com.example.tmo.domain.tag.service.TagDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/tag")
@RestController
public class TagController {
    private final TagCreateService tagCreateService;
    private final TagDeleteService tagDeleteService;
    private final TagDetailsService tagDetailsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public void createTag(@PathVariable("id") Long recruitmentId,
                          @RequestBody TagCreateRequest request) {
        tagCreateService.execute(recruitmentId, request);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable("id") Long recruitmentId) {
        tagDeleteService.execute(recruitmentId);
    }

    @GetMapping("/{id}")
    public List<TagDetailsResponse> detailTag(@PathVariable("id") Long recruitmentId) {
        return tagDetailsService.execute(recruitmentId);
    }
}
