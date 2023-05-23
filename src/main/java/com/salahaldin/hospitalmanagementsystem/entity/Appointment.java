package com.salahaldin.hospitalmanagementsystem.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Appointment {
    @Id
    @GeneratedValue
    private long id;
    private Date date;
}