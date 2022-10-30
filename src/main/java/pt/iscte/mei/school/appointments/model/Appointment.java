package pt.iscte.mei.school.appointments.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private short capacityRequired;
    private String curricularUnit;
    private boolean supervisionalApproval;

    @Builder
    public Appointment(final LocalDateTime startDate, final LocalDateTime endDate, final short capacityRequired, final String curricularUnit, final boolean supervisionalApproval) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacityRequired = capacityRequired;
        this.curricularUnit = curricularUnit;
        this.supervisionalApproval = supervisionalApproval;
    }
}
