package pt.iscte.mei.school.appointments.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iscte.mei.school.appointments.application.AppointmentApplicationService;
import pt.iscte.mei.school.appointments.application.dto.RegisterAppointmentDTO;
import pt.iscte.mei.school.appointments.model.Appointment;

import java.util.List;


@RestController
@RequestMapping(path = "/appointments")
public class AppointmentController {

    private AppointmentApplicationService service;

    @PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public List<Appointment> getAll(@RequestBody RegisterAppointmentDTO dto) {
        return null;
    } 

}