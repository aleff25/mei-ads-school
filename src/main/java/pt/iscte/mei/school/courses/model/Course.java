package pt.iscte.mei.school.courses.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "courses")
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String location;
    private String curricularUnit;
    private Shift shift;
    private int capacity;
    private int capacityUsed;

    @Builder
    public Course(final String id, final String name, final String location, final String curricularUnit, final Shift shift, final int capacity, final int capacityUsed) {
        this.id = id;
        this.name = name;
        this.shift = shift;
        this.capacity = capacity;
        this.capacityUsed = capacityUsed;
    }

    public int capacityRemaining() {
        return capacity - capacityUsed;
    }

    public void addNewStudentsToCourse(int quantity) {
        this.capacityUsed += quantity;
    }
}
