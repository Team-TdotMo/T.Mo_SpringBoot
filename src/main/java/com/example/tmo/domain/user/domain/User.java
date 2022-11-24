package com.example.tmo.domain.user.domain;

import com.example.tmo.domain.recruitment.domain.type.MajorCategory;
import com.example.tmo.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseIdEntity {

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 30)
    private String email;

    @NotNull
    private int grade;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MajorCategory majorCategory;

    @NotNull
    private String password;

    @Builder
    public User(String name, String email, int grade, MajorCategory majorCategory, String password) {
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.majorCategory = majorCategory;
        this.password = password;
    }
}