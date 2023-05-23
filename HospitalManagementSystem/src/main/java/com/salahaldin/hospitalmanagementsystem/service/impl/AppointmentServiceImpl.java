package com.salahaldin.hospitalmanagementsystem.service.impl;

import com.salahaldin.hospitalmanagementsystem.dto.AppointmentDTO;
import com.salahaldin.hospitalmanagementsystem.entity.Appointment;
import com.salahaldin.hospitalmanagementsystem.entity.Doctor;
import com.salahaldin.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.salahaldin.hospitalmanagementsystem.repository.AppointmentRepository;
import com.salahaldin.hospitalmanagementsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDto) {
        System.out.println(appointmentDto.toString());
        Appointment appointment = convertToEntity(appointmentDto);
        System.out.println(appointment);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return convertToDto(savedAppointment);
    }


    @Override
    public AppointmentDTO getAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        return convertToDto(appointment);
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDto) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        appointment.setDate(appointmentDto.getDate());
        Appointment updatedAppointment = appointmentRepository.save(appointment);
        return convertToDto(updatedAppointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Appointment", "id", id);
        }
        appointmentRepository.deleteById(id);
    }


    private Appointment convertToEntity(AppointmentDTO appointmentDto) {
        Appointment appointment = new Appointment();

        appointment.setDate(appointmentDto.getDate());

        return appointment;
    }
    private AppointmentDTO convertToDto(Appointment appointment) {
        AppointmentDTO appointmentDto = new AppointmentDTO();

        appointmentDto.setId(appointment.getId());
        appointmentDto.setDate(appointment.getDate());

        return appointmentDto;
    }

}
