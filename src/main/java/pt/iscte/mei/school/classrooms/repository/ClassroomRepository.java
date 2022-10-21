package pt.iscte.mei.school.classrooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.classrooms.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, String> {
}
