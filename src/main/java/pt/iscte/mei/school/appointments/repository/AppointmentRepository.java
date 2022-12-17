package pt.iscte.mei.school.appointments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.iscte.mei.school.appointments.model.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    @Query(value = "from Appointment t where t.startDate >= :startDate AND t.endDate <= :endDate")
    List<Appointment> getAllBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query(value = "from Appointment t where t.startDate >= :startDate AND t.endDate <= :endDate AND t.classroom = " +
            ":classroomId OR t.course = :courseId")
    List<Appointment> getAllBetweenDatesAndClassroom(@Param("startDate") LocalDateTime startDate,
                                                     @Param("endDate") LocalDateTime endDate,
                                                     @Param("classroomId") String classroomId,
                                                     @Param("courseId") String courseId);
}
