package com.salahaldin.hospitalmanagementsystem.service;

import com.salahaldin.hospitalmanagementsystem.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO createAppointment(AppointmentDTO appointmentDto);
    AppointmentDTO getAppointment(Long id);
    List<AppointmentDTO> getAllAppointments();
    AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDto);
    void deleteAppointment(Long id);
}
