package pt.iscte.mei.school.courses.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Getter
@Table(name = "courses")
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Course {

    private final String id;
    private final String name;
    private final Shift shift;
    private final short capacity;
    private final short capacityUsed;

    @Builder
    public Course(final String id, final String name, final Shift shift, final short capacity, final short capacityUsed) {
        this.id = id;
        this.name = name;
        this.shift = shift;
        this.capacity = capacity;
        this.capacityUsed = capacityUsed;
    }

    public int capacityRemaining() {
        return capacity - capacityUsed;
    }
}
