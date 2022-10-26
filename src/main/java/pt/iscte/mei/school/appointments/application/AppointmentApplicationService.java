package pt.iscte.mei.school.appointments.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.mei.school.appointments.repository.AppointmentRepository;

@Service
@Transactional
@AllArgsConstructor
public class AppointmentApplicationService {

    private final AppointmentRepository appointmentRepository;

    public void register() {

    }
}
