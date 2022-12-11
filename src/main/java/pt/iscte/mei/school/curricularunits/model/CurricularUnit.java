package pt.iscte.mei.school.curricularunits.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "curricular_units")
@Entity
@NoArgsConstructor
public class CurricularUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;


}
