package com.example.tmo.domain.tag.domain;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Tag extends BaseIdEntity {

    private String category;

    @ManyToOne
    @JoinColumn(name = "recruitment_id")
    private Recruitment recruitment;

    @Builder
    public Tag(String category, Recruitment recruitment) {
        this.category = category;
        this.recruitment = recruitment;
    }
}
