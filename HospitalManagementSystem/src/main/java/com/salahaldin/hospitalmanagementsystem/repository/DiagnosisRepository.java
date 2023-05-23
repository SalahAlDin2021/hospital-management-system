package com.salahaldin.hospitalmanagementsystem.repository;

import com.salahaldin.hospitalmanagementsystem.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
