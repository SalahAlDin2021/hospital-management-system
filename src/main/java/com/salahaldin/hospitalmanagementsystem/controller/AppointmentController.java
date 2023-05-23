package com.salahaldin.hospitalmanagementsystem.controller;

import com.salahaldin.hospitalmanagementsystem.dto.AppointmentDTO;
import com.salahaldin.hospitalmanagementsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private final AppointmentService appointmentService;


    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDto) {
        return new ResponseEntity<>(appointmentService.createAppointment(appointmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable("id") Long id) {
        return new ResponseEntity<>(appointmentService.getAppointment(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        return new ResponseEntity<>(appointmentService.getAllAppointments(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable("id") Long id, @RequestBody AppointmentDTO appointmentDto) {
        return new ResponseEntity<>(appointmentService.updateAppointment(id, appointmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

