package pt.iscte.mei.school.students.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Getter
@Table(name = "students")
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Student {

    private String id;
    private String name;
    private String courseId;
    private String classroomId;

    @Builder
    public Student(final String id, final String name, final String courseId, final String classroomId) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.classroomId = classroomId;
    }
}
