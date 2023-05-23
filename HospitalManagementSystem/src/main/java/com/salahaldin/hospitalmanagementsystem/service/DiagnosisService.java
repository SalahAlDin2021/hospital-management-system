package com.salahaldin.hospitalmanagementsystem.service;

import com.salahaldin.hospitalmanagementsystem.dto.DiagnosisDTO;

import java.util.List;

public interface DiagnosisService {
    DiagnosisDTO createDiagnosis(DiagnosisDTO diagnosisDto);
    DiagnosisDTO getDiagnosis(Long id);
    List<DiagnosisDTO> getAllDiagnoses();
    DiagnosisDTO updateDiagnosis(Long id, DiagnosisDTO diagnosisDto);
    void deleteDiagnosis(Long id);
}