package org.egdeveloper.web.restcontrollers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.Patient;
import org.egdeveloper.service.IDoctorService;
import org.egdeveloper.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping(value = "/patientService")
public class PatientServiceController {

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

    @Autowired
    @Qualifier("patientService")
    private IPatientService patientService;

    /**
     * Add patient
     * @param doctorID doctor id
     * @param patient patient instance
     * @return patient
     */
    @RequestMapping(value = "/doctors/{doctorID}/patient", method = RequestMethod.POST)
    public ResponseEntity<Patient> addPatient(@PathVariable("doctorID") Integer doctorID, @RequestBody Patient patient){
        Doctor doctor = doctorService.getDoctorByID(doctorID);
        if(doctor == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        patientService.addPatient(doctor, patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.PUT)
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
        if(!patientService.checkPatientExist(patient))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        patientService.editPatientInfo(patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    /**
     * Get patient by id
     * @param patientID patient id
     * @return patient
     */
    @RequestMapping(value = "/patients/{patientID}", method = RequestMethod.GET)
    public ResponseEntity<Patient> getPatientById(@PathVariable("patientID") Integer patientID){
        Patient patient = patientService.getPatientById(patientID);
        if(patient == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(patient, HttpStatus.OK);
    }
    /**
     * Find all patients
     * @return patients
     */
    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public ResponseEntity<Collection<Patient>> findAllPatients(){
        return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
    }

    /**
     * Retrieve patients from doctor entry
     * @param doctorID doctor id
     * @return patients
     */
    @RequestMapping(value = "/doctors/{doctorID}/patients", method = RequestMethod.GET)
    public ResponseEntity<Collection<Patient>> retrievePatientsForDoctor(@PathVariable("doctorID") Integer doctorID)
    {
        Doctor doctorEntry = doctorService.getDoctorByID(doctorID);
        if(doctorEntry == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(doctorEntry.getPatients(), HttpStatus.OK);
    }

    /**
     * Delete patient
     * @param patientID patient ID
     * @return patient
     */
    @RequestMapping(value = "/patients/{patientID}", method = RequestMethod.DELETE)
    public ResponseEntity<Patient> deletePatient(@PathVariable("patientID") Integer patientID){
        Patient patient = patientService.getPatientById(patientID);
        if(patient == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        patientService.removePatient(patientID);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
}
