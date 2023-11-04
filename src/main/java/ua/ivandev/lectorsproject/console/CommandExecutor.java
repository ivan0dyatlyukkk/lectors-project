package ua.ivandev.lectorsproject.console;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.ivandev.lectorsproject.enums.Command;
import ua.ivandev.lectorsproject.model.Lector;
import ua.ivandev.lectorsproject.service.DepartmentService;
import ua.ivandev.lectorsproject.service.LectorService;

@Component
@RequiredArgsConstructor
public class CommandExecutor {
    private static final String HEAD_OF_DEPARTMENT_ANSWER = "Head of %s department is %s";
    private static final String AVERAGE_SALARY_ANSWER = "The average salary of %s is %f";
    private static final String UNSUPPORTED_COMMAND_ANSWER = "The command is unsupported!";

    private final LectorService lectorService;
    private final DepartmentService departmentService;

    public String execute(Command command, String value) {
        return switch (command) {
            case GET_HEAD_OF_DEPARTMENT
                    -> HEAD_OF_DEPARTMENT_ANSWER.formatted(
                            value, departmentService.getHeadOfDepartment(value)
                    );
            case SHOW_STATISTICS
                    -> departmentService.getStatisticByDepartmentName(value);
            case SHOW_NUMBER_OF_EMPLOYEES
                    -> String.valueOf(
                            departmentService.getNumberOfEmployeesByDepartmentName(value)
                    );
            case SHOW_AVERAGE_SALARY
                    -> AVERAGE_SALARY_ANSWER.formatted(
                            value, departmentService.getAverageSalaryByDepartmentName(value)
                    );
            case GLOBAL_SEARCH
                    -> lectorService.search(value).stream()
                                    .map(Lector::getName)
                                    .collect(Collectors.joining(", "));
            case UNSUPPORTED
                    -> UNSUPPORTED_COMMAND_ANSWER;
        };
    }
}
