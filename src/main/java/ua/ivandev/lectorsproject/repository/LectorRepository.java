package ua.ivandev.lectorsproject.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ivandev.lectorsproject.model.Lector;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query(
            value = "SELECT * FROM lectors INNER JOIN lectors_departments "
                    + "ON lectors.id = lectors_departments.lector_id "
                    + "WHERE lectors_departments.department_id = :id",
            nativeQuery = true
    )
    List<Lector> findAllByDepartmentId(Long id);

    List<Lector> findAllByNameContainsIgnoreCase(String name);
}
