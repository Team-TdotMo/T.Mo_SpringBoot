package com.example.tmo.domain.applicant.domain.repository;

import com.example.tmo.domain.applicant.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
