package com.example.tmo.domain.image.controller;

import com.example.tmo.domain.image.controller.dto.response.ImageUrlResponse;
import com.example.tmo.domain.image.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ImageUploadController {

    private final ImageUploadService imageUploadService;

    // @RequestPart : Content-type이 'multipart/form-data'와 관련된 경우 사용
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/recruitment/{id}")
    public void imageUpload(@PathVariable("id") Long recruitmentId,
                                        @RequestPart(value = "image", required = false) List<MultipartFile> images) {
        imageUploadService.imageUpload(recruitmentId, images);
    }
}
