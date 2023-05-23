package com.salahaldin.hospitalmanagementsystem.service;

import com.salahaldin.hospitalmanagementsystem.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDto);
    PatientDTO getPatient(Long id);
    List<PatientDTO> getAllPatients();
    PatientDTO updatePatient(Long id, PatientDTO patientDto);
    void deletePatient(Long id);
}

