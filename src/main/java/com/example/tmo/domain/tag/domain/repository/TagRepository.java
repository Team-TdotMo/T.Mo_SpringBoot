package com.example.tmo.domain.tag.domain.repository;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.tag.domain.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag, Long> {
    Optional<Tag> deleteByRecruitmentId (Recruitment recruitmentId);
    List<Tag> findAllByRecruitment (Recruitment recruitmentId);

}
