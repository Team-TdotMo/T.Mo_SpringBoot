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
import javax.persistence.OneToMany;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Tag extends BaseIdEntity {

    private String type;

    @ManyToOne
    @JoinColumn
    private Recruitment recruitment;

    @Builder
    public Tag(String type, Recruitment recruitment) {
        this.type = type;
        this.recruitment = recruitment;
    }
}
