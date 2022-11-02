package pt.iscte.mei.school.appointments.application;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.mei.school.appointments.application.dto.RegisterAppointmentDTO;
import pt.iscte.mei.school.appointments.application.dto.SearchAppointmentDTO;
import pt.iscte.mei.school.appointments.exception.MeiAdsSchoolAppointmentAlreadyRegisteredException;
import pt.iscte.mei.school.appointments.model.Appointment;
import pt.iscte.mei.school.appointments.repository.AppointmentRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class AppointmentApplicationService {

    private final AppointmentRepository repository;

    public void register(RegisterAppointmentDTO dto) {
        var appointment = Appointment.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .capacityRequired(dto.getCapacity())
                .build();

        log.info("Saving new appointment = {}", appointment);

        List<Appointment> appointmentsRegistered = repository.getAllBetweenDates(appointment.getStartDate(),
                appointment.getEndDate());

        if (!appointmentsRegistered.isEmpty()) {
            throw new MeiAdsSchoolAppointmentAlreadyRegisteredException();
        }

        repository.saveAndFlush(appointment);
    }

    public List<Appointment> search(SearchAppointmentDTO dto) {
        log.info("Searching all appointments with dates between {} and {}", dto.getStartDate(), dto.getEndDate());

        return repository.getAllBetweenDates(dto.getStartDate(),
                dto.getEndDate());
    }


}
