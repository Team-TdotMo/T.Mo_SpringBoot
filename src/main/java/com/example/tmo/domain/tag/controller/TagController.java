package com.example.tmo.domain.tag.controller;

import com.example.tmo.domain.tag.controller.dto.request.TagCreateRequest;
import com.example.tmo.domain.tag.service.TagCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RequiredArgsConstructor
@RequestMapping("/tag")
@RestController
public class TagController {

    private TagCreateService tagCreateService;

    @PostMapping("/write/{id}")
    public void createTag(TagCreateRequest request, @PathVariable("id") Long recruitmentId) {
        tagCreateService.execute(request, recruitmentId);
    }
}
