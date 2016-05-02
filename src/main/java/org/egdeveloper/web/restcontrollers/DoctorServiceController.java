package org.egdeveloper.web.restcontrollers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.service.data.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/doctorService")
public class DoctorServiceController {

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

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
    @RequestMapping(value = "/doctor/{doctorID}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public Doctor updateDoctorAccount(@PathVariable("doctorID") Integer doctorID, @RequestBody Doctor doctor,
                                      HttpServletRequest request,
                                      HttpServletResponse response)
    {
        Doctor currentDoctor = doctorService.getDoctorByID(doctorID);
        if(currentDoctor == null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        doctor.setPatients(currentDoctor.getPatients());
        doctorService.updateDoctorInfo(doctor);
        return doctor;
    }

    /**
     * Delete current doctor account
     * @param doctorID doctor id
     * @return response entry
     */
    @RequestMapping(value = "/doctor/{doctorID}", method = RequestMethod.DELETE, produces = "application/json")
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
     * Fetch all doctor accounts
     * @return doctor accounts
     */
    @RequestMapping(value = "/doctor/{doctorID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Doctor> getDoctorByID(@PathVariable("doctorID") Integer doctorID){
        Doctor doctor = doctorService.getDoctorByID(doctorID);
        if(doctor == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    /**
     * Fetch all doctor accounts
     * @return doctor accounts
     */
    @RequestMapping(value = "/doctor", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Doctor> getDoctorByLoginAndPassword(@RequestParam("login") String login, @RequestParam("password") String password){
        Doctor doctor = doctorService.getDoctorByLogin(login);
        if(doctor == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if(!BCrypt.checkpw(password, doctor.getPassword()))
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    /**
     * Fetch all doctor accounts
     * @return doctor accounts
     */
    @RequestMapping(value = "/doctors", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Collection<Doctor>> getDoctors(){
        return new ResponseEntity<>(doctorService.getDoctors(), HttpStatus.OK);
    }

}
