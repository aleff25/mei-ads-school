package pt.iscte.mei.school.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.courses.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
}
