package com.example.tmo.domain.tag.domain.repository;

import com.example.tmo.domain.recruitment.domain.Recruitment;
import com.example.tmo.domain.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
public interface TagRepository extends CrudRepository<Tag, Long> {
    Optional<Tag> deleteByRecruitmentId (Recruitment recruitmentId);
    List<Tag> findAllByRecruitment (Recruitment recruitmentId);

=======
public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> deleteByRecruitmentId (Long recruitmentId);
>>>>>>> 28a8925efc5acd75c196971d13f277e093b6f508
}
