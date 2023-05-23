package com.salahaldin.hospitalmanagementsystem.controller;

import com.salahaldin.hospitalmanagementsystem.dto.PatientDTO;
import com.salahaldin.hospitalmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@ RequestBody PatientDTO patientDto) {
        return new ResponseEntity<>(patientService.createPatient(patientDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Long id) {
        return new ResponseEntity<>(patientService.getPatient(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable("id") Long id, @RequestBody PatientDTO patientDto) {
        return new ResponseEntity<>(patientService.updatePatient(id, patientDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
