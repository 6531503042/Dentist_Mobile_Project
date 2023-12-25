package app.appointment.repository;

import app.appointment.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    //Query Custom Command
    Doctor findByDoctorId(Long docId);
}
