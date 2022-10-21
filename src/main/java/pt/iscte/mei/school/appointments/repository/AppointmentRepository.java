package pt.iscte.mei.school.appointments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.appointments.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
