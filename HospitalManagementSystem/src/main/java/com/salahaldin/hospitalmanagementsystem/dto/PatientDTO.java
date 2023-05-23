package com.salahaldin.hospitalmanagementsystem.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private long id;
    private String name;
    private Date dateOfBirth;
    private String contact;
}
