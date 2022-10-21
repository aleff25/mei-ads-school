package pt.iscte.mei.school.appointments.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.time.LocalDateTime;


@Getter
@Table(name = "appointments")
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Appointment {

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final short capacityRequired;
    private final String curricularUnit;

    @Builder
    public Appointment(final LocalDateTime startDate, final LocalDateTime endDate, final short capacityRequired, final String curricularUnit) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacityRequired = capacityRequired;
        this.curricularUnit = curricularUnit;
    }
}
