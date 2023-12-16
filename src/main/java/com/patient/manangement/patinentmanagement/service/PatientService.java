package com.patient.manangement.patinentmanagement.service;

import com.patient.manangement.patinentmanagement.exception.ResourceNotFoundException;
import com.patient.manangement.patinentmanagement.model.Patient;
import com.patient.manangement.patinentmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
    @Cacheable(value= "patients", key = "#id")
    public Patient getPatientById(Long id){
        Optional<Patient> optionalPatient = patientRepository.findById( id);

        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            throw new ResourceNotFoundException("Patient not found with ID: " + id);
        }
    }
    public Patient createPatient(Patient patient){
        return  patientRepository.save(patient);
    }
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }
}
