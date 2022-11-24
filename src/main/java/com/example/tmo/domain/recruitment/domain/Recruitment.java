package com.example.tmo.domain.recruitment.domain;

import com.example.tmo.domain.recruitment.domain.type.Category;
import com.example.tmo.domain.recruitment.domain.type.MajorCategory;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Recruitment extends BaseTimeEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", nullable = false)
    private User user;

    @Column(length = 60)
    private String title;

    @Column(length = 4000)
    private String content;

    private String technology;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MajorCategory majorCategory;

    @Builder
    public Recruitment(String title, String content, String technology, Category category,
                       MajorCategory majorCategory, User user) {
        this.title = title;
        this.content = content;
        this.technology = technology;
        this.category = category;
        this.majorCategory = majorCategory;
        this.user = user;
    }
}
