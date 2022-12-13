package com.example.tmo.domain.tag.controller;

import com.example.tmo.domain.tag.controller.dto.request.TagCreateRequest;
import com.example.tmo.domain.tag.controller.dto.response.TagDetailsResponse;
import com.example.tmo.domain.tag.service.TagCreateService;
import com.example.tmo.domain.tag.service.TagDeleteService;
import com.example.tmo.domain.tag.service.TagDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/tag")
@RestController
public class TagController {
    private TagCreateService tagCreateService;
    private final TagDeleteService tagDeleteService;
    private final TagDetailsService tagDetailsService;

    @PostMapping("/write/{id}")
    public void createTag(TagCreateRequest request, @PathVariable("id") Long recruitmentId) {
        tagCreateService.execute(request, recruitmentId);
    }

    @GetMapping("/{id}")
    public List<TagDetailsResponse> detailTag(@PathVariable("id") Long recruitmentId) {
        return tagDetailsService.execute(recruitmentId);
    }
}
