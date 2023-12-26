package app.appointment.repository;

import app.appointment.model.Appointment;
import app.appointment.model.Doctor;
import app.appointment.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    void deleteById(Long appointId);

    List<Appointment> findByDoctorAndAppointmentDateAndTimeSlot(Doctor doctor, LocalDate appointmentDate, TimeSlot timeSlot);

//    void deleteById(AppointmentKey appointmentKey);
}
