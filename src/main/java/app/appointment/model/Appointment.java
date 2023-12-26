package app.appointment.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private AppointmentStatus status = AppointmentStatus.Booked;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Enumerated(EnumType.STRING)
    private TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    private String appointmentCondition;

    //Constructor
    public Appointment() {
        //Default Constructor
        this.createdAt = convertBangkokTime(new Timestamp(System.currentTimeMillis()));
    }

    public Appointment(Long id, AppointmentStatus status, Timestamp createdAt, LocalDate appointmentDate, TimeSlot timeSlot, Doctor doctor, String appointmentCondition) {
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.appointmentDate = appointmentDate;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
        this.appointmentCondition = appointmentCondition;
    }

    //Convert timestamp => Bangkok_Time
    private Timestamp convertBangkokTime(Timestamp timestamp) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        ZoneId currentZone = ZoneId.of("UTC");
        ZoneId bangkokZone = ZoneId.of("Asia/Bangkok");
        ZonedDateTime utcDateTime = ZonedDateTime.of(localDateTime, currentZone);
        ZonedDateTime bangkokDateTime = utcDateTime.withZoneSameInstant(bangkokZone);
        return Timestamp.valueOf(bangkokDateTime.toLocalDateTime());
    }

    //Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getAppointmentCondition() {
        return appointmentCondition;
    }

    public void setAppointmentCondition(String appointmentCondition) {
        this.appointmentCondition = appointmentCondition;
    }
}
