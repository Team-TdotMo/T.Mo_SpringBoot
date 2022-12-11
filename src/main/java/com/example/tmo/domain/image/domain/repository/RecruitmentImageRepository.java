package com.example.tmo.domain.image.domain.repository;

import com.example.tmo.domain.image.domain.RecruitmentImage;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RecruitmentImageRepository extends CrudRepository<RecruitmentImage, Long> {
    List<RecruitmentImage> findAllByRecruitment(Recruitment Recruitment);
}
