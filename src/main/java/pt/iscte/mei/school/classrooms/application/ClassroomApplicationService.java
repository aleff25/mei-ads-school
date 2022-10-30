package pt.iscte.mei.school.classrooms.application;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.mei.school.classrooms.model.Classroom;
import pt.iscte.mei.school.classrooms.repository.ClassroomRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class ClassroomApplicationService {

    private final ClassroomRepository repository;

    private List<Classroom> searchAll() {
        log.info("Searching all classrooms");
        return repository.findAll();
    }

    private List<Classroom> searchByName(String name) {
        log.info("Searching classroom by name = {}", name);

        return repository.findAllByNameLikeIgnoreCase(name);
    }
}
