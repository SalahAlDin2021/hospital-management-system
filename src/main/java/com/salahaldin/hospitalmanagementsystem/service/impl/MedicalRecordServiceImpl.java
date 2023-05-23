package com.salahaldin.hospitalmanagementsystem.service.impl;

import com.salahaldin.hospitalmanagementsystem.dto.MedicalRecordDTO;
import com.salahaldin.hospitalmanagementsystem.entity.MedicalRecord;
import com.salahaldin.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.salahaldin.hospitalmanagementsystem.repository.MedicalRecordRepository;
import com.salahaldin.hospitalmanagementsystem.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public MedicalRecordDTO createMedicalRecord(MedicalRecordDTO medicalRecordDto) {
        MedicalRecord medicalRecord = convertToEntity(medicalRecordDto);
        MedicalRecord savedMedicalRecord = medicalRecordRepository.save(medicalRecord);
        return convertToDto(savedMedicalRecord);
    }

    @Override
    public MedicalRecordDTO getMedicalRecord(Long id) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MedicalRecord", "id", id));
        return convertToDto(medicalRecord);
    }

    @Override
    public List<MedicalRecordDTO> getAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findAll();
        return medicalRecords.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public MedicalRecordDTO updateMedicalRecord(Long id, MedicalRecordDTO medicalRecordDto) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MedicalRecord", "id", id));

        medicalRecord.setDate(medicalRecordDto.getDate());
        medicalRecord.setDiagnosis(medicalRecordDto.getDiagnosis());
        medicalRecord.setTreatment(medicalRecordDto.getTreatment());
        MedicalRecord updatedMedicalRecord = medicalRecordRepository.save(medicalRecord);
        return convertToDto(updatedMedicalRecord);
    }

    @Override
    public void deleteMedicalRecord(Long id) {
        if (!medicalRecordRepository.existsById(id)) {
            throw new ResourceNotFoundException("MedicalRecord", "id", id);
        }
        medicalRecordRepository.deleteById(id);
    }

    private MedicalRecordDTO convertToDto(MedicalRecord medicalRecord) {
        MedicalRecordDTO medicalRecordDto = new MedicalRecordDTO();

        medicalRecordDto.setId(medicalRecord.getId());
        medicalRecordDto.setDate(medicalRecord.getDate());
        medicalRecordDto.setDiagnosis(medicalRecord.getDiagnosis());
        medicalRecordDto.setTreatment(medicalRecord.getTreatment());

        return medicalRecordDto;
    }

    private MedicalRecord convertToEntity(MedicalRecordDTO medicalRecordDto) {
        MedicalRecord medicalRecord = new MedicalRecord();

        medicalRecord.setId(medicalRecordDto.getId());
        medicalRecord.setDate(medicalRecordDto.getDate());
        medicalRecord.setDiagnosis(medicalRecordDto.getDiagnosis());
        medicalRecord.setTreatment(medicalRecordDto.getTreatment());
        // Set other fields of the entity as needed

        return medicalRecord;
    }
}
