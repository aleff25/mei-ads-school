package pt.iscte.mei.school.appointments.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pt.iscte.mei.school.classrooms.model.Caracteristic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Getter
@Table(name = "appointments")
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue
    private String id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int capacityRequired;
    private String curricularUnit;
    private Caracteristic caracteristic;
    private boolean supervisionalApproval;

    @Builder
    public Appointment(final LocalDateTime startDate, final LocalDateTime endDate, final int capacityRequired,
                       final String curricularUnit, final Caracteristic caracteristic, final boolean supervisionalApproval) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacityRequired = capacityRequired;
        this.curricularUnit = curricularUnit;
        this.caracteristic = caracteristic;
        this.supervisionalApproval = supervisionalApproval;
    }
}
