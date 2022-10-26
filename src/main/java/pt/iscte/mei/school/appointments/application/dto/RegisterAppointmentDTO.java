package pt.iscte.mei.school.appointments.application.dto;


import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor(staticName = "from")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@ApiModel(description = "Information's to register a new appointment")
public class RegisterAppointmentDTO {

    @NotBlank(message = "{RegisterAppointmentDTO.startDate.NotBlank}")
    private String startDate;

    @NotBlank(message = "{RegisterAppointmentDTO.endDate.NotBlank}")
    private String endDate;

    @NotBlank(message = "{RegisterAppointmentDTO.classroomId.NotBlank}")
    private String classroomId;

    @NotBlank(message = "{RegisterAppointmentDTO.courseId.NotBlank}")
    private String courseId;
}
