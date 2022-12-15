package com.example.tmo.domain.applicant.domain;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.user.domain.User;
import com.example.tmo.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Applicant extends BaseIdEntity {

    @NotNull
    private Long user;

    @ManyToOne
    @JoinColumn(name = "recruitment_id")
    private Recruitment recruitment;

    @Builder
    public Applicant(Long user, Recruitment recruitment) {
        this.user = user;
        this.recruitment = recruitment;
    }
}
