package com.patient.manangement.patinentmanagement.controller;

import com.patient.manangement.patinentmanagement.model.Patient;
import com.patient.manangement.patinentmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {



    private final PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/info")
    public String getAppInfo() {
        return "Application Name: " + appName + "\nVersion: " + appVersion;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> patientList = patientService.getAllPatient();
        return ResponseEntity.ok(patientList);
    }
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        Patient createdPatient = patientService.createPatient(patient);
        return  new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }
}

