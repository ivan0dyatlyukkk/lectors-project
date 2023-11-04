package ua.ivandev.lectorsproject.service;

import ua.ivandev.lectorsproject.model.Department;

public interface DepartmentService {
    String getHeadOfDepartment(String name);

    int getNumberOfEmployeesByDepartmentName(String name);

    double getAverageSalaryByDepartmentName(String name);

    String getStatisticByDepartmentName(String name);

    Department getByName(String name);
}
