package app.appointment.service;

import app.appointment.model.Appointment;
import app.appointment.model.Doctor;
import app.appointment.model.TimeSlot;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AppointmentService {

    boolean isAppointmentSlotAvailable(Doctor doctor, LocalDate appointmentDate, TimeSlot timeSlot);

    void bookAppointment(Appointment appointment);

    List<Appointment> getAllAppointment();

    void cancelAppointment(Appointment appointment);
}
