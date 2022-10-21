package pt.iscte.mei.school.classrooms.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Getter
@Table(name = "classrooms")
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Classroom {

    private final String id;
    private final String name;
    private final short capacity;

    @Builder
    public Classroom(final String id, final String name, final short capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }
}
