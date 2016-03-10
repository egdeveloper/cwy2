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
@RequestMapping(value = "/webService")
public class RESTClientRequestsHandlerController {

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

    @Autowired
    @Qualifier("patientService")
    private IPatientService patientService;

    /**
     * Create doctor account
     * @param doctor doctor instance
     * @return response entry
     */
    @RequestMapping(value = "/doctor", method = RequestMethod.POST, produces = "application/json")
    public Doctor createDoctorAccount(@RequestBody Doctor doctor,
                                      HttpServletRequest request,
                                      HttpServletResponse response)
    {
        if(doctor == null)
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        doctorService.addDoctor(doctor);
        return doctor;
    }
    /**
     * Update current doctor account
     * @param doctorID doctor id
     * @param doctor doctor instance
     * @return response entry
     */
    @RequestMapping(value = "/doctors/{doctorID}", method = RequestMethod.PUT, produces = "application/json")
    public Doctor updateDoctorAccount(@PathVariable("doctorID") Integer doctorID, @RequestBody Doctor doctor,
                                      HttpServletRequest request,
                                      HttpServletResponse response)
    {
        Doctor currentDoctor = doctorService.getDoctorByID(doctorID);
        if(currentDoctor == null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        doctorService.updateDoctorInfo(doctor);
        return doctor;
    }

    /**
     * Delete current doctor account
     * @param doctorID doctor id
     * @return response entry
     */
    @RequestMapping(value = "/doctors/{doctorID}", method = RequestMethod.DELETE, produces = "application/json")
    public Doctor deleteDoctorAccount(@PathVariable("doctorID") Integer doctorID,
                                      HttpServletRequest request,
                                      HttpServletResponse response){
        Doctor currentDoctor = doctorService.getDoctorByID(doctorID);
        if(currentDoctor == null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        doctorService.removeDoctor(doctorID);
        return currentDoctor;
    }

    /**
     * Retrieve patients from doctor entry
     * @param doctorID doctor id
     * @return response entry
     */
    @RequestMapping(value = "/doctors/{doctorID}/patients", method = RequestMethod.GET)
    public ResponseEntity<Collection<Patient>> retrievePatientsForDoctor(@PathVariable("doctorID") Integer doctorID)
    {
        Doctor doctorEntry = doctorService.getDoctorByID(doctorID);
        if(doctorEntry == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(doctorEntry.getPatients(), HttpStatus.OK);
    }
}
