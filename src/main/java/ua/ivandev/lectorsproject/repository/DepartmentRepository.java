package ua.ivandev.lectorsproject.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.ivandev.lectorsproject.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
}
