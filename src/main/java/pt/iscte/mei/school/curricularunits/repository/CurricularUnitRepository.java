package pt.iscte.mei.school.curricularunits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.curricularunits.model.CurricularUnit;

public interface CurricularUnitRepository extends JpaRepository<CurricularUnit, String> {
}
