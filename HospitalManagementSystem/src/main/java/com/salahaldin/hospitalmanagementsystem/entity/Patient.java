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
public class Patient {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Date dateOfBirth;
    private String contact;
}
