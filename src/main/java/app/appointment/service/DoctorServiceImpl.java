package app.appointment.service;

import app.appointment.model.Appointment;
import app.appointment.model.Doctor;
import app.appointment.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    //Constructor
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Appointment> getDoctorAppointments(Long docId) {
        Doctor doctor = doctorRepository.findByDoctorId(docId);

        if (doctor == null) {
            throw new IllegalStateException("The Doctor doesn't seem to be exist");
        }

        return doctor.getAppointments();
    }
}
