package com.example.tmo.domain.recruitment.domain;

import com.example.tmo.domain.image.domain.Image;
import com.example.tmo.domain.recruitment.domain.type.RecruitmentType;
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
import java.sql.Date;
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

    @NotNull
    private Date period;

    @NotNull
    @Column(length = 4000)
    private String content;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RecruitmentType recruitmentType;

    @NotNull
    private Integer number;

<<<<<<< Updated upstream
    @OneToMany(mappedBy = "recruitment")
    private Integer number;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<RecruitmentImage> recruitmentImage;
=======
    @OneToMany(mappedBy = "recruitment", cascade = CascadeType.REMOVE)
    private List<Image> recruitmentImage;
>>>>>>> Stashed changes

    @Builder
    public Recruitment(String title, Date period, String content,
                       RecruitmentType recruitmentType, User user, Integer number,
<<<<<<< Updated upstream
                       RecruitmentType recruitmentType, MajorType majorType, User user, Integer number,
                       List<RecruitmentImage> recruitmentImage) {
=======
                       List<Image> recruitmentImage) {
>>>>>>> Stashed changes
        this.title = title;
        this.period = period;
        this.content = content;
        this.recruitmentType = recruitmentType;
        this.user = user;
        this.number = number;
        this.recruitmentImage = recruitmentImage;
    }

<<<<<<< Updated upstream
    public void updateRecruitment(String title, LocalDate period, String content, String technology,
=======
    public void updateRecruitment(Integer number, String title, Date period, String content,
>>>>>>> Stashed changes
                                  RecruitmentType recruitmentType) {
                                  RecruitmentType recruitmentType, MajorType majorType) {

        //TODO number 추가
        this.title = title;
        this.period = period;
        this.content = content;
        this.recruitmentType = recruitmentType;
    }
}
