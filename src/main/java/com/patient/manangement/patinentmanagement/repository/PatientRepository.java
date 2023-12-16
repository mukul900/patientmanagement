package com.patient.manangement.patinentmanagement.repository;

import com.patient.manangement.patinentmanagement.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
