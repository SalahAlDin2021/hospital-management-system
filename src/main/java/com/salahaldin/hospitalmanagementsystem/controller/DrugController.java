package com.salahaldin.hospitalmanagementsystem.controller;

import com.salahaldin.hospitalmanagementsystem.dto.DrugDTO;
import com.salahaldin.hospitalmanagementsystem.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@
        RestController
@RequestMapping("/drugs")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @PostMapping

    public ResponseEntity<DrugDTO> createDrug(@RequestBody DrugDTO drugDto) {
        return new ResponseEntity<>(drugService.createDrug(drugDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrugDTO> getDrug(@PathVariable("id") Long id) {
        return new ResponseEntity<>(drugService.getDrug(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DrugDTO>> getAllDrugs() {
        return new ResponseEntity<>(drugService.getAllDrugs(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DrugDTO> updateDrug(@PathVariable("id") Long id, @RequestBody DrugDTO drugDto) {
        return new ResponseEntity<>(drugService.updateDrug(id, drugDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrug(@PathVariable("id") Long id) {
        drugService.deleteDrug(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
