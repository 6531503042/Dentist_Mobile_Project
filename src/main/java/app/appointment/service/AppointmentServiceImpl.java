package app.appointment.service;

import app.appointment.model.Appointment;
import app.appointment.model.Doctor;
import app.appointment.model.TimeSlot;
import app.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentServiceImpl() {
        //Default Constructor
    }

//    @Override
//    public void bookAppointment(@RequestBody Appointment appointment) {
//        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointment.getId());
//        if(appointmentOptional.isEmpty()) {
//            appointmentRepository.save(appointment);
//        } else {
//            throw new IllegalStateException("Appointment with ID already exist or present");
//        }
//    }

    @Override
    public boolean isAppointmentSlotAvailable(Doctor doctor, LocalDate appointmentDate, TimeSlot timeSlot) {
        List<Appointment> existingAppointment = appointmentRepository
                .findByDoctorAndAppointmentDateAndTimeSlot(doctor, appointmentDate, timeSlot);
        return existingAppointment.isEmpty();
    }



    @Override
    public void bookAppointment(@RequestBody Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public void cancelAppointment(Appointment appointment) {
        Long appointId = appointment.getId();
        appointmentRepository.deleteById(appointId);
}


}
