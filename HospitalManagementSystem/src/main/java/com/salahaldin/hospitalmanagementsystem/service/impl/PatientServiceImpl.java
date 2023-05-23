package com.salahaldin.hospitalmanagementsystem.service.impl;

import com.salahaldin.hospitalmanagementsystem.dto.PatientDTO;
import com.salahaldin.hospitalmanagementsystem.entity.Patient;
import com.salahaldin.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.salahaldin.hospitalmanagementsystem.repository.PatientRepository;
import com.salahaldin.hospitalmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDto) {
        Patient patient = convertToEntity(patientDto);
        Patient savedPatient = patientRepository.save(patient);
        return convertToDto(savedPatient);
    }

    @Override
    public PatientDTO getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        return convertToDto(patient);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDto) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));

        patient.setName(patientDto.getName());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setContact(patientDto.getContact());

        Patient updatedPatient = patientRepository.save(patient);
        return convertToDto(updatedPatient);
    }

    @Override
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Patient", "id", id);
        }
        patientRepository.deleteById(id);
    }

    private PatientDTO convertToDto(Patient patient) {
        PatientDTO patientDto = new PatientDTO();

        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setDateOfBirth(patient.getDateOfBirth());
        patientDto.setContact(patient.getContact());

        return patientDto;
    }

    private Patient convertToEntity(PatientDTO patientDto) {
        Patient patient = new Patient();

        patient.setId(patientDto.getId());
        patient.setName(patientDto.getName());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setContact(patientDto.getContact());

        return patient;
    }
}
