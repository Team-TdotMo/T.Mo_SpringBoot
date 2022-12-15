package com.example.tmo.domain.image.service;

<<<<<<< Updated upstream
import com.example.tmo.domain.image.controller.dto.response.ImageUrlResponse;
import com.example.tmo.domain.image.domain.RecruitmentImage;
=======
import com.example.tmo.domain.image.domain.Image;
>>>>>>> Stashed changes
import com.example.tmo.domain.image.domain.repository.RecruitmentImageRepository;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.recruitment.facade.RecruitmentFacade;
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
    private final RecruitmentImageRepository recruitmentImageRepository;
    private final RecruitmentFacade recruitmentFacade;

    @Transactional
    public void imageUpload(Long recruitmentId, List<MultipartFile> images) {
        Recruitment recruitment = recruitmentFacade.findByRecruitmentId(recruitmentId);

        for (MultipartFile file : images) {
            recruitmentImageRepository.save(
                    new Image(recruitment, s3Facade.uploadImage(file)));
        }
    }
}
