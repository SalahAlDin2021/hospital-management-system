package com.salahaldin.hospitalmanagementsystem.service.impl;

import com.salahaldin.hospitalmanagementsystem.dto.DoctorDTO;
import com.salahaldin.hospitalmanagementsystem.entity.Doctor;
import com.salahaldin.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.salahaldin.hospitalmanagementsystem.repository.DoctorRepository;
import com.salahaldin.hospitalmanagementsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDto) {
        Doctor doctor = convertToEntity(doctorDto);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return convertToDto(savedDoctor);
    }

    @Override
    public DoctorDTO getDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
        return convertToDto(doctor);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDto) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));

        doctor.setName(doctorDto.getName());
        doctor.setSpecialty(doctorDto.getSpecialty());
        doctor.setContact(doctorDto.getContact());
        doctor.setAvailability(doctorDto.getAvailability());

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return convertToDto(updatedDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor", "id", id);
        }
        doctorRepository.deleteById(id);
    }

    private DoctorDTO convertToDto(Doctor doctor) {
        DoctorDTO doctorDto = new DoctorDTO();

        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSpecialty(doctor.getSpecialty());
        doctorDto.setContact(doctor.getContact());
        doctorDto.setAvailability(doctor.getAvailability());

        return doctorDto;
    }

    private Doctor convertToEntity(DoctorDTO doctorDto) {
        Doctor doctor = new Doctor();

        doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setSpecialty(doctorDto.getSpecialty());
        doctor.setContact(doctorDto.getContact());
        doctor.setAvailability(doctorDto.getAvailability());

        return doctor;
    }
}
