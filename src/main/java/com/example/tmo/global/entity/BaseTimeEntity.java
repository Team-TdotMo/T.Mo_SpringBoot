package com.example.tmo.global.entity;

import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity extends BaseIdEntity {

    @NotNull
    @LastModifiedDate
    private LocalDate modifiedAt;
}
