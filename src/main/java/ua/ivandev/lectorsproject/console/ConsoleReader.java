package ua.ivandev.lectorsproject.console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ua.ivandev.lectorsproject.enums.Command;
import ua.ivandev.lectorsproject.enums.InvalidCommandException;

@Component
public class ConsoleReader {
    private static final String GET_HEAD_OF_DEPARTMENT_COMMAND = "Who is head of department";
    private static final List<String> SHOW_STATISTICS_COMMAND_KEY_WORDS = List.of("Show",
                                                                            "statistics");
    private static final String SHOW_AVERAGE_SALARY_COMMAND = "Show the average salary for"
                                                                        + " the department";
    private static final String SHOW_NUMBER_OF_EMPLOYEES_COMMAND = "Show count of employee for";
    private static final String GLOBAL_SEARCH_COMMAND = "Global search by";

    public static Command getCommand(String input) {
        if (input.contains(GET_HEAD_OF_DEPARTMENT_COMMAND)) {
            return Command.GET_HEAD_OF_DEPARTMENT;
        } else if (containsAllWords(input, SHOW_STATISTICS_COMMAND_KEY_WORDS)) {
            return Command.SHOW_STATISTICS;
        } else if (input.contains(SHOW_AVERAGE_SALARY_COMMAND)) {
            return Command.SHOW_AVERAGE_SALARY;
        } else if (input.contains(SHOW_NUMBER_OF_EMPLOYEES_COMMAND)) {
            return Command.SHOW_NUMBER_OF_EMPLOYEES;
        } else if (input.contains(GLOBAL_SEARCH_COMMAND)) {
            return Command.GLOBAL_SEARCH;
        } else {
            return Command.UNSUPPORTED;
        }
    }

    public static String getValue(String input) {
        return switch (getCommand(input)) {
            case GET_HEAD_OF_DEPARTMENT
                            -> input.substring(GET_HEAD_OF_DEPARTMENT_COMMAND.length() + 1);
            case SHOW_STATISTICS
                            -> getValueFromMiddle(input, SHOW_STATISTICS_COMMAND_KEY_WORDS);
            case SHOW_AVERAGE_SALARY
                            -> input.substring(SHOW_AVERAGE_SALARY_COMMAND.length() + 1);
            case SHOW_NUMBER_OF_EMPLOYEES
                            -> input.substring(SHOW_NUMBER_OF_EMPLOYEES_COMMAND.length() + 1);
            case GLOBAL_SEARCH
                            -> input.substring(GLOBAL_SEARCH_COMMAND.length() + 1);
            case UNSUPPORTED
                            -> throw new InvalidCommandException(
                                    "Can't get a value from unsupported command!"
                            );
        };
    }

    public static boolean containsAllWords(String string, List<String> words) {
        return Arrays.stream(string.split(" "))
                .filter(words::contains)
                .count() == words.size();
    }

    private static String getValueFromMiddle(String baseString, List<String> commandWords) {
        return Arrays.stream(baseString.split(" "))
                .filter(word -> !commandWords.contains(word))
                .collect(Collectors.joining(" "));
    }
}
