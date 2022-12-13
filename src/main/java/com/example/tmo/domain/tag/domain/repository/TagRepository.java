package com.example.tmo.domain.tag.domain.repository;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> deleteByRecruitmentId (Long recruitmentId);
}
