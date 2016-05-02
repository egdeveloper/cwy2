package org.egdeveloper.web.restcontrollers;

import org.egdeveloper.converters.CustomJSONMapper;
import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.data.entities.Patient;
import org.egdeveloper.service.data.IDoctorService;
import org.egdeveloper.service.data.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping(value = "/patientService")
public class PatientServiceController {

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

    @Autowired
    @Qualifier("patientService")
    private IPatientService patientService;

    @Autowired
    @Qualifier("customJSONMapper")
    private CustomJSONMapper jsonMapper;

    /**
     * Add patient
     * @param doctorID doctor id
     * @param patient patient instance
     * @return patient
     */
    @RequestMapping(value = "/doctor/{doctorID}/patient", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Patient> addPatient(@PathVariable("doctorID") Integer doctorID, @RequestBody Patient patient){
        Doctor doctor = doctorService.getDoctorByID(doctorID);
        if(doctor == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        patientService.addPatient(doctor, patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
        if(!patientService.checkPatientExist(patient))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Patient currentPatient = patientService.getPatientById(patient.getId());
        patient.setDoctor(currentPatient.getDoctor());
        patient.setBioChemTests(currentPatient.getBioChemTests());
        patient.setCommonBloodTests(currentPatient.getCommonBloodTests());
        patient.setCommonUreaTests(currentPatient.getCommonUreaTests());
        patient.setDailyExcreationTests(currentPatient.getDailyExcreationTests());
        patient.setStoneInVitroTests(currentPatient.getStoneInVitroTests());
        patient.setStoneInVivoTests(currentPatient.getStoneInVivoTests());
        patient.setTitrationTests(currentPatient.getTitrationTests());
        patient.setUreaColorTests(currentPatient.getUreaColorTests());
        patientService.updatePatient(patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    /**
     * Get patient by id
     * @param patientID patient id
     * @return patient
     */
    @RequestMapping(value = "/patient/{patientID}", method = RequestMethod.GET, produces = "application/json")
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
    @RequestMapping(value = "/patients", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Collection<Patient>> findAllPatients(){
        return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
    }

    /**
     * Retrieve patients from doctor entry
     * @param doctorID doctor id
     * @return patients
     */
    @RequestMapping(value = "/doctor/{doctorID}/patients", method = RequestMethod.GET, produces = "application/json")
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
    @RequestMapping(value = "/patient/{patientID}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Patient> deletePatient(@PathVariable("patientID") Integer patientID){
        Patient patient = patientService.getPatientById(patientID);
        if(patient == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        patientService.removePatient(patientID);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/{patientID}/medicalTest", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<MedicalTest> addMedicalTest(@PathVariable("patientID") Integer patientID, HttpServletRequest request, HttpServletResponse response) throws IOException{
        Patient patient = patientService.getPatientById(patientID);
        if(patient == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        MedicalTest medicalTest = jsonMapper.readValue(request.getInputStream(), MedicalTest.class);
        if(medicalTest == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        patientService.addMedicalTest(patient, medicalTest);
        return new ResponseEntity<>(medicalTest, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/{patientID}/medicalTestList", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Set<MedicalTest>> findAllTestsOfPatient(@PathVariable("patientID") Integer patientID){
        Patient patient = patientService.getPatientById(patientID);
        if(patient == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(patient.retrieveAllPatientTests(), HttpStatus.OK);
    }
}
