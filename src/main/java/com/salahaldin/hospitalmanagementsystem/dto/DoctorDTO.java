package com.salahaldin.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private long id;
    private String name;
    private String specialty;
    private String contact;
    private String availability;
}
