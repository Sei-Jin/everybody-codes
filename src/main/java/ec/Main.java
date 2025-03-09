package ec;

import static ec.Printer.print;

public class Main {
    
    public static void runAndPrint(int day) {
        final var quest = new Quest(day);
        final var executionData = Runner.run(quest);
        print(quest, executionData);
    }
}
