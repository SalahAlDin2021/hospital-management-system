package com.salahaldin.hospitalmanagementsystem.controller;

import com.salahaldin.hospitalmanagementsystem.dto.DiagnosisDTO;
import com.salahaldin.hospitalmanagementsystem.dto.PatientDTO;
import com.salahaldin.hospitalmanagementsystem.service.DiagnosisService;
import com.salahaldin.hospitalmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @PostMapping
    public ResponseEntity<DiagnosisDTO> createDiagnosis(@ RequestBody DiagnosisDTO diagnosisDto) {
        return new ResponseEntity<>(diagnosisService.createDiagnosis(diagnosisDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosisDTO> getDiagnosis(@PathVariable("id") Long id) {
        return new ResponseEntity<>(diagnosisService.getDiagnosis(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DiagnosisDTO>> getAllDiagnosis() {
        return new ResponseEntity<>(diagnosisService.getAllDiagnoses(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiagnosisDTO> updateDiagnosis(@PathVariable("id") Long id, @RequestBody DiagnosisDTO diagnosisDto) {
        return new ResponseEntity<>(diagnosisService.updateDiagnosis(id, diagnosisDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiagnosis(@PathVariable("id") Long id) {
        diagnosisService.deleteDiagnosis(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
