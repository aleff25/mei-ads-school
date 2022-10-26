package pt.iscte.mei.school.classrooms.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Table(name = "classrooms")
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Classroom {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    private short capacity;

    @Builder
    public Classroom(final String id, final String name, final short capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }
}
