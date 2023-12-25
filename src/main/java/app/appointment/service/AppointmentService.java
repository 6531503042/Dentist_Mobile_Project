package app.appointment.service;

import app.appointment.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {

    void bookAppointment(Appointment appointment);

    List<Appointment> getAllAppointment();

    void cancelAppointment(Appointment appointment);
}
