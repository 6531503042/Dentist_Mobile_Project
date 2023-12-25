package app.appointment.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    private String doctorName;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @OneToMany
    private List<Appointment> appointments;
}
