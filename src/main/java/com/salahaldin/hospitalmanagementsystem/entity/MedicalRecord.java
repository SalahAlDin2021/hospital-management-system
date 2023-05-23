package com.salahaldin.hospitalmanagementsystem.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class MedicalRecord {
    @Id
    @GeneratedValue
    private long id;
    Date date;
    String diagnosis;
    String treatment;
}
