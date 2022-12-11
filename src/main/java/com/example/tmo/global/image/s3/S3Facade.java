package com.example.tmo.global.image.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.tmo.global.exception.FileSaveFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class S3Facade {

    private final S3Properties s3Properties;
    private final AmazonS3Client amazonS3Client;

    public String uploadImage(MultipartFile file) {

        String fileName;

        try {
            fileName = saveImage(file);
        } catch (Exception e) {
            throw FileSaveFailedException.EXCEPTION;
        }

        return fileName;
    }

    private ObjectMetadata getObjectMetadata(MultipartFile image) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(image.getSize());
        objectMetadata.setContentType(image.getContentType());

        return objectMetadata;
    }

    private String saveImage(MultipartFile file) throws IOException {
        String fileName = s3Properties.getBucket() + "/" + UUID.randomUUID() + file.getOriginalFilename();

        amazonS3Client.putObject(new PutObjectRequest(s3Properties.getBucket(), fileName,
                file.getInputStream(), getObjectMetadata(file)));
        return fileName;
    }

    public String getImageUrl(String fileName) {
        return amazonS3Client.getUrl(s3Properties.getBucket(), fileName).toString();
    }

    public void delete(String path) {
        amazonS3Client.deleteObject(new DeleteObjectRequest(s3Properties.getBucket(), path));
    }
}
