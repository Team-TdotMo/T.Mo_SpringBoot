package com.example.tmo.domain.image.domain;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class RecruitmentImage extends BaseIdEntity {

    @Column(nullable = false)
    private String imagePath;
    @ManyToOne
    @JoinColumn(name = "recruitment")
    private Recruitment recruitment;

    @Builder
    public RecruitmentImage(Recruitment recruitment, String imagePath) {
        this.recruitment = recruitment;
        this.imagePath = imagePath;
    }

}
