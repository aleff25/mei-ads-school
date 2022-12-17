package pt.iscte.mei.school.appointments.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pt.iscte.mei.school.classrooms.model.Caracteristic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@Table(name = "appointments")
@Entity
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int capacityRequired;
    private String curricularUnit;

    private String classroom;

    private String course;
    private Caracteristic caracteristic;
    private boolean supervisionalApproval;

    @Builder
    public Appointment(final LocalDateTime startDate, final LocalDateTime endDate, final int capacityRequired,
                       final String curricularUnit, final String classroom, final String course,
                       final Caracteristic caracteristic,
                       final boolean supervisionalApproval) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacityRequired = capacityRequired;
        this.curricularUnit = curricularUnit;
        this.classroom = classroom;
        this.course = course;
        this.caracteristic = caracteristic;
        this.supervisionalApproval = supervisionalApproval;
    }
}
