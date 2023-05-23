package com.salahaldin.hospitalmanagementsystem.controller;

import com.salahaldin.hospitalmanagementsystem.dto.MedicalRecordDTO;
import com.salahaldin.hospitalmanagementsystem.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalrecords")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecordDTO> createMedicalRecord(@RequestBody MedicalRecordDTO medicalRecordDto) {
        return new ResponseEntity<>(medicalRecordService.createMedicalRecord(medicalRecordDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordDTO> getMedicalRecord(@PathVariable("id") Long id) {
        return new ResponseEntity<>(medicalRecordService.getMedicalRecord(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecordDTO>> getAllMedicalRecords() {
        return new ResponseEntity<>(medicalRecordService.getAllMedicalRecords(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecordDTO> updateMedicalRecord(@PathVariable("id") Long id, @RequestBody MedicalRecordDTO medicalRecordDto) {
        System.out.println(medicalRecordDto.toString());
        return new ResponseEntity<>(medicalRecordService.updateMedicalRecord(id, medicalRecordDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable("id") Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
