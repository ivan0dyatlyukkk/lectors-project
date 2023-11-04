package ua.ivandev.lectorsproject.service.impl;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ivandev.lectorsproject.exceptions.DepartmentNotFoundException;
import ua.ivandev.lectorsproject.model.Department;
import ua.ivandev.lectorsproject.model.Lector;
import ua.ivandev.lectorsproject.repository.DepartmentRepository;
import ua.ivandev.lectorsproject.service.DepartmentService;
import ua.ivandev.lectorsproject.service.LectorService;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final LectorService lectorService;

    @Override
    public String getHeadOfDepartment(String name) {
        return getByName(name).getHeadOfDepartment();
    }

    @Override
    public int getNumberOfEmployeesByDepartmentName(String name) {
        Department department = getByName(name);
        return lectorService.getAllByDepartmentId(department.getId()).size();
    }

    @Override
    public double getAverageSalaryByDepartmentName(String name) {
        Department department = getByName(name);
        return lectorService.getAllByDepartmentId(department.getId())
                .stream()
                .mapToDouble(lector -> lector.getSalary().doubleValue())
                .average()
                .orElse(0);
    }

    @Override
    public String getStatisticByDepartmentName(String name) {
        Department department = getByName(name);
        return lectorService.getAllByDepartmentId(department.getId()).stream()
                .collect(
                        Collectors.groupingBy(
                                Lector::getDegree, Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .map(
                        e -> e.getKey() + " - " + e.getValue()
                )
                .collect(Collectors.joining("\n"));
    }

    @Override
    public Department getByName(String name) {
        return departmentRepository.findByName(name)
                .orElseThrow(
                        () -> new DepartmentNotFoundException(
                                "Can't find a department by such name as: " + name
                        )
                );
    }
}
