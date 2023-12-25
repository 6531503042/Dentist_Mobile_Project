package app.appointment.service;

import app.appointment.model.Appointment;
import app.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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
