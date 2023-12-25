package app.appointment.controller;

import app.appointment.model.Appointment;
import app.appointment.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    @Autowired
    private AppointmentService appointmentService;

    //Constructor
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> bookAppointment(@RequestBody Appointment appointment) {
        try {
            appointmentService.bookAppointment(appointment);
            logger.info("New Appointment booked successfully: {}", appointment);
            return ResponseEntity.ok("New Appointment booked is added");
        } catch (Exception e) {
            logger.error("Error Book Another Appointment as this appointment is already booked", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error Book Another Appointment as this appointment is already booked");
        }
    }


//    @DeleteMapping("/delete")
//    public ResponseEntity<String> cancelAppointment(@RequestParam String userEmail) {
//
//    }


    //Bypass check first
    @GetMapping("/getAll")
    public ResponseEntity<List<Appointment>> getAllAppointment() {
        List<Appointment> appointments = appointmentService.getAllAppointment();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

}
