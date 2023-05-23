package com.salahaldin.hospitalmanagementsystem.service.impl;

import com.salahaldin.hospitalmanagementsystem.dto.DiagnosisDTO;
import com.salahaldin.hospitalmanagementsystem.entity.Diagnosis;
import com.salahaldin.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.salahaldin.hospitalmanagementsystem.repository.DiagnosisRepository;
import com.salahaldin.hospitalmanagementsystem.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public DiagnosisDTO createDiagnosis(DiagnosisDTO diagnosisDto) {
        Diagnosis diagnosis = convertToEntity(diagnosisDto);
        Diagnosis savedDiagnosis = diagnosisRepository.save(diagnosis);
        return convertToDto(savedDiagnosis);
    }


    @Override
    public DiagnosisDTO getDiagnosis(Long id) {
        Diagnosis diagnosis = diagnosisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Diagnosis", "id", id));
        return convertToDto(diagnosis);
    }

    @Override
    public List<DiagnosisDTO> getAllDiagnoses() {
        List<Diagnosis> diagnoses = diagnosisRepository.findAll();
        return diagnoses.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public DiagnosisDTO updateDiagnosis(Long id, DiagnosisDTO diagnosisDto) {
        Diagnosis diagnosis = diagnosisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Diagnosis", "id", id));

        // Updating diagnosis based on the DTO received
        diagnosis.setName(diagnosisDto.getName());
        diagnosis.setDescription(diagnosisDto.getDescription());

        Diagnosis updatedDiagnosis = diagnosisRepository.save(diagnosis);
        return convertToDto(updatedDiagnosis);
    }


    @Override
    public void deleteDiagnosis(Long id) {
        if (!diagnosisRepository.existsById(id)) {
            throw new ResourceNotFoundException("Diagnosis", "id", id);
        }
        diagnosisRepository.deleteById(id);
    }


    private DiagnosisDTO convertToDto(Diagnosis diagnosis) {
        DiagnosisDTO diagnosisDto = new DiagnosisDTO();

        diagnosisDto.setId(diagnosis.getId());
        diagnosisDto.setName(diagnosis.getName());
        diagnosisDto.setDescription(diagnosis.getDescription());

        return diagnosisDto;
    }

    private Diagnosis convertToEntity(DiagnosisDTO diagnosisDto) {
        Diagnosis diagnosis = new Diagnosis();

        diagnosis.setId(diagnosisDto.getId());
        diagnosis.setName(diagnosisDto.getName());
        diagnosis.setDescription(diagnosisDto.getDescription());

        return diagnosis;
    }
}
