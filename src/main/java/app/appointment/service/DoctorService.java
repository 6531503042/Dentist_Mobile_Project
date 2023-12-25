package app.appointment.service;

import app.appointment.model.Appointment;
import app.appointment.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {


    List<Doctor> getAllDoctor();

    Doctor addDoctor(Doctor doctor);

    List<Appointment> getDoctorAppointments(Long docId);
}
