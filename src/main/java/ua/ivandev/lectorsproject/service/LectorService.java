package ua.ivandev.lectorsproject.service;

import java.util.List;
import ua.ivandev.lectorsproject.model.Lector;

public interface LectorService {
    List<Lector> getAllByDepartmentId(Long id);

    List<Lector> search(String name);
}
