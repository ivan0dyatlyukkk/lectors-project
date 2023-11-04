package ua.ivandev.lectorsproject.console;

import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsoleApplication implements CommandLineRunner {
    private static final String EXIT_COMMAND = "Exit";

    private final CommandExecutor commandExecutor;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Your request: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase(EXIT_COMMAND)) {
                break;
            }

            System.out.println(commandExecutor.execute(
                    ConsoleReader.getCommand(input),
                    ConsoleReader.getValue(input))
            );
        }
    }
}
