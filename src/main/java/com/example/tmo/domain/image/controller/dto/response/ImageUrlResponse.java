package com.example.tmo.domain.image.controller.dto.response;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
public class ImageUrlResponse {
    List<String> imageUrl;
}
