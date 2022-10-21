package pt.iscte.mei.school.domain.courses;

import lombok.Data;

@Data
public class Course {

    private String name;
    private Shift shift;
    private short capacity;
    private short capacityUsed;
}
