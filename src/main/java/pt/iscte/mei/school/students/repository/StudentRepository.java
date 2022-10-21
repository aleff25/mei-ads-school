package pt.iscte.mei.school.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.students.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
}
