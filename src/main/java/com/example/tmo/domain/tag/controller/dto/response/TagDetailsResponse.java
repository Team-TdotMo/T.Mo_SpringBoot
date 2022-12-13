package com.example.tmo.domain.tag.controller.dto.response;

import com.example.tmo.domain.tag.domain.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class TagDetailsResponse {

    private String category;

    public static TagDetailsResponse categoryList(Tag tag) {
        return TagDetailsResponse.builder()
                .category(tag.getCategory())
                .build();
    }
}
