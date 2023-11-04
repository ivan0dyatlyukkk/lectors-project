package ua.ivandev.lectorsproject.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ivandev.lectorsproject.model.Lector;
import ua.ivandev.lectorsproject.repository.LectorRepository;
import ua.ivandev.lectorsproject.service.LectorService;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Override
    public List<Lector> getAllByDepartmentId(Long id) {
        return lectorRepository.findAllByDepartmentId(id);
    }

    @Override
    public List<Lector> search(String name) {
        return lectorRepository.findAllByNameContainsIgnoreCase(name);
    }
}
