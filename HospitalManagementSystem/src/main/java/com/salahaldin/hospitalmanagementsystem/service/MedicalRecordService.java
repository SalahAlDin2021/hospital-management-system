package com.salahaldin.hospitalmanagementsystem.service;

import com.salahaldin.hospitalmanagementsystem.dto.MedicalRecordDTO;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecordDTO createMedicalRecord(MedicalRecordDTO medicalRecordDto);
    MedicalRecordDTO getMedicalRecord(Long id);
    List<MedicalRecordDTO> getAllMedicalRecords();
    MedicalRecordDTO updateMedicalRecord(Long id, MedicalRecordDTO medicalRecordDto);
    void deleteMedicalRecord(Long id);
}
