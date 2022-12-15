package com.example.tmo.domain.user.domain;


import com.example.tmo.domain.recruitment.domain.type.MajorType;
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

    @Column(nullable = false, columnDefinition = "tinyint")
    private Integer grade;

    @Enumerated(EnumType.STRING)
    private MajorType MajorType;

    @Column(nullable = false)
    private String password;

    private Integer star;

    private String content;

    private String introduce;

    private String technology;

    private String project;

    private String myProject;

    @Builder
    public User(String name, String email, Integer grade, MajorType MajorType, String password, Integer star, String introduce
            , String technology, String project, String myProject, String content) {
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.MajorType = MajorType;
        this.password = password;
        this.technology = technology;
        this.star = star;
        this.content = content;
        this.introduce = introduce;
        this.project = project;
        this.myProject = myProject;
    }
}
