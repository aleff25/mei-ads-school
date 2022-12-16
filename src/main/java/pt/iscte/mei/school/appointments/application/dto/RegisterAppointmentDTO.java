package pt.iscte.mei.school.appointments.application.dto;


import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@ApiModel(description = "Information's to register a new appointment")
public final class RegisterAppointmentDTO {

    @NotNull(message = "{RegisterAppointmentDTO.startDate.NotNull}")
    private LocalDateTime startDate;

    @NotNull(message = "{RegisterAppointmentDTO.endDate.NotNull}")
    private LocalDateTime endDate;

    @NotBlank(message = "{RegisterAppointmentDTO.classroomId.NotBlank}")
    private String classroomId;

    @NotBlank(message = "{RegisterAppointmentDTO.courseId.NotBlank}")
    private String courseId;

    @NotBlank(message = "{RegisterAppointmentDTO.curricularUnitId.NotBlank}")
    private String curricularUnitId;

    @NotNull(message = "{RegisterAppointmentDTO.capacity.NotNull}")
    private int capacity;

    @NotEmpty(message = "{RegisterAppointmentDTO.features.NotEmpty}")
    private List<String> features;
}
