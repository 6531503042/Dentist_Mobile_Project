package app.appointment.controller;

import app.appointment.model.Appointment;
import app.appointment.model.Doctor;
import app.appointment.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private DoctorService doctorService;

    //Constructor
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public DoctorController() {
        //Default Controller Constructor
    }

    @GetMapping("/getAllDoctor")
    public ResponseEntity<List<Doctor>> getAllDoctor() {
        List<Doctor> doctors = doctorService.getAllDoctor();

        if (doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(doctors);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(doctors);
        }
    }


    @PostMapping("/addDoctor")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
        try {
            doctorService.addDoctor(doctor);
            logger.info("Doctor has been Added");
            return ResponseEntity.status(HttpStatus.OK).body("Doctor has been Added");
        } catch (Exception e) {
            logger.error("Error adding doctor for doctor name", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{docId}/appointments")
    public ResponseEntity<List<Appointment>> getDoctorAppointments(@PathVariable Long docId) {
        List<Appointment> appointmentLists = null;
        try {
            appointmentLists = doctorService.getDoctorAppointments(docId);
            if (appointmentLists.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(appointmentLists);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(appointmentLists);
            }
        } catch (Exception e) {
            logger.error("Error retrieving appointments for Doctor ID: {}", docId, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }





}
