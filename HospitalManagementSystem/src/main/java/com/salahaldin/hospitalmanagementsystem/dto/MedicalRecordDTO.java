package com.salahaldin.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordDTO {
    private long id;
    Date date;
    String diagnosis;
    String treatment;
}
