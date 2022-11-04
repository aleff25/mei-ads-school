package pt.iscte.mei.school.files.excel.application;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.mei.school.appointments.application.AppointmentApplicationService;
import pt.iscte.mei.school.appointments.application.dto.ReadXLSXFileAppointmentDTO;
import pt.iscte.mei.school.appointments.model.Appointment;
import pt.iscte.mei.school.files.excel.helper.ExcelHelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
@Log4j2
public class ExcelApplicationService {

    private AppointmentApplicationService appointmentService;

    public void save(MultipartFile file) {
        try {
            List<ReadXLSXFileAppointmentDTO> dto = ExcelHelper.excelToAppointments(file.getInputStream());

            dto.forEach(o -> System.out.println(o.toString()));
            //TODO: call all repositories to save the models
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Appointment> appointments = appointmentService.searchAll();

        ByteArrayInputStream in = ExcelHelper.appointmentsToExcel(appointments);
        return in;
    }

}
