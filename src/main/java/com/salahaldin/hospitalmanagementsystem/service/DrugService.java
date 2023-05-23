package com.salahaldin.hospitalmanagementsystem.service;

import com.salahaldin.hospitalmanagementsystem.dto.DrugDTO;

import java.util.List;

public interface DrugService {
    DrugDTO createDrug(DrugDTO drugDto);
    DrugDTO getDrug(Long id);
    List<DrugDTO> getAllDrugs();
    DrugDTO updateDrug(Long id, DrugDTO drugDto);
    void deleteDrug(Long id);
}
