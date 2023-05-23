package com.salahaldin.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private long id;
    private Date date;
}