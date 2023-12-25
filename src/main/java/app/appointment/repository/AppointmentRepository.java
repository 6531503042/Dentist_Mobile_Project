package app.appointment.repository;

import app.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    void deleteById(Long appointId);

//    void deleteById(AppointmentKey appointmentKey);
}
