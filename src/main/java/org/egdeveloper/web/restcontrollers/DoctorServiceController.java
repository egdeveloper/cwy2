package org.egdeveloper.web.restcontrollers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * Fetch all doctor accounts
     * @return doctor accounts
     */
    @RequestMapping(value = "/doctors", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Collection<Doctor>> getDoctors(){
        return new ResponseEntity<>(doctorService.getDoctors(), HttpStatus.OK);
    }
}
