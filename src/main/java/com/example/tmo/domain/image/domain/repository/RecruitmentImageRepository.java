package com.example.tmo.domain.image.domain.repository;

import com.example.tmo.domain.image.domain.Image;
import com.example.tmo.domain.recruitment.domain.Recruitment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecruitmentImageRepository extends CrudRepository<Image, Long> {
    List<Image> findAllByRecruitment(Recruitment Recruitment);
}
