package com.example.tmo.domain.image.service;

import com.example.tmo.domain.image.controller.dto.response.ImageUrlResponse;
import com.example.tmo.global.image.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class ImageUploadService {

    private final S3Facade s3Facade;

    @Transactional
    public ImageUrlResponse imageUpload(List<MultipartFile> images) {
        List<String> imageUrl = images
                .stream()
                .map(s3Facade::uploadImage)
                .collect(Collectors.toList());

        return new ImageUrlResponse(imageUrl);
    }
}
