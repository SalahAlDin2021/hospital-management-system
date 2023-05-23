package com.salahaldin.hospitalmanagementsystem.service.impl;

import com.salahaldin.hospitalmanagementsystem.dto.DrugDTO;
import com.salahaldin.hospitalmanagementsystem.entity.Drug;
import com.salahaldin.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.salahaldin.hospitalmanagementsystem.repository.DrugRepository;
import com.salahaldin.hospitalmanagementsystem.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    public DrugServiceImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public DrugDTO createDrug(DrugDTO drugDto) {
        Drug drug = convertToEntity(drugDto);
        Drug savedDrug = drugRepository.save(drug);
        return convertToDto(savedDrug);
    }

    @Override
    public DrugDTO getDrug(Long id) {
        Drug drug = drugRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Drug", "id", id));
        return convertToDto(drug);
    }

    @Override
    public List<DrugDTO> getAllDrugs() {
        List<Drug> drugs = drugRepository.findAll();
        return drugs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public DrugDTO updateDrug(Long id, DrugDTO drugDto) {
        Drug drug = drugRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Drug", "id", id));

        drug.setName(drugDto.getName());
        drug.setStartTaking(drugDto.getStartTaking());
        drug.setEndTaking(drugDto.getEndTaking());

        Drug updatedDrug = drugRepository.save(drug);
        return convertToDto(updatedDrug);
    }

    @Override
    public void deleteDrug(Long id) {
        if (!drugRepository.existsById(id)) {
            throw new ResourceNotFoundException("Drug", "id", id);
        }
        drugRepository.deleteById(id);
    }

    private DrugDTO convertToDto(Drug drug) {
        DrugDTO drugDto = new DrugDTO();

        drugDto.setId(drug.getId());
        drugDto.setName(drug.getName());
        drugDto.setStartTaking(drug.getStartTaking());
        drugDto.setEndTaking(drug.getEndTaking());

        return drugDto;
    }

    private Drug convertToEntity(DrugDTO drugDto) {
        Drug drug = new Drug();

        drug.setId(drugDto.getId());
        drug.setName(drugDto.getName());
        drug.setStartTaking(drugDto.getStartTaking());
        drug.setEndTaking(drugDto.getEndTaking());

        return drug;
    }
}
