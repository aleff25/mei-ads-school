package pt.iscte.mei.school.courses.application;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.mei.school.courses.model.Course;
import pt.iscte.mei.school.courses.repository.CourseRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class CouseApplicationService {

    private final CourseRepository repository;

    private List<Course> searchAll() {
        log.info("Searching all courses");
        return repository.findAll();
    }

    private List<Course> searchByName(String name) {
        log.info("Searching course by name = {}", name);

        return repository.findAllByNameLikeIgnoreCase(name);
    }
}
