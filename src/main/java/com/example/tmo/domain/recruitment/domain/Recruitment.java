package com.example.tmo.domain.recruitment.domain;

import com.example.tmo.domain.image.domain.RecruitmentImage;
import com.example.tmo.domain.recruitment.domain.type.RecruitmentType;
import com.example.tmo.domain.tag.domain.Tag;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Recruitment extends BaseTimeEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @NotNull
    @Column(length = 60)
    private String title;

    private LocalDate period;

    @NotNull
    @Column(length = 4000)
    private String content;

    private String technology;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RecruitmentType recruitmentType;

<<<<<<< HEAD
=======
    private Integer number;

    @OneToMany(mappedBy = "recruitment")
>>>>>>> main
    private Integer number;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<RecruitmentImage> recruitmentImage;

    @Builder
    public Recruitment(String title, LocalDate period, String content, String technology,
                       RecruitmentType recruitmentType, User user, Integer number,
                       List<RecruitmentImage> recruitmentImage) {
        this.title = title;
        this.period = period;
        this.content = content;
        this.technology = technology;
        this.recruitmentType = recruitmentType;
        this.user = user;
        this.number = number;
        this.recruitmentImage = recruitmentImage;
    }

    public void updateRecruitment(Integer number, String title, LocalDate period, String content, String technology,
                                  RecruitmentType recruitmentType) {

        this.number = number;
        this.title = title;
        this.period = period;
        this.content = content;
        this.technology = technology;
        this.recruitmentType = recruitmentType;
    }
}
