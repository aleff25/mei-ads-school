package pt.iscte.mei.school.domain.students;

import lombok.Data;
import pt.iscte.mei.school.domain.classrooms.Classroom;
import pt.iscte.mei.school.domain.courses.Course;

@Data
public class Student {

    private String name;
    private Course course;
    private Classroom classroom;
}
