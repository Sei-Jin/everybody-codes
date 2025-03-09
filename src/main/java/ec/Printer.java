package ec;

import java.util.List;

public class Printer {
    
    public static void print(Quest quest, List<ExecutionData> runData) {
        System.out.printf("\nDay: %d\n", quest.questId());
        printHorizontalLine();
        
        System.out.printf("%-12s|%12s |%13s\n", "Part", "Time", "Result");
        printHorizontalLine();
        
        for (final var data : runData) {
            System.out.printf("%-12s|", "Part " + data.name());
            printData(data.result(), data.executionTimeInMicroseconds());
        }
        
        final var totalTime = runData
            .stream()
            .mapToLong(ExecutionData::executionTimeInMicroseconds)
            .sum();
        
        printHorizontalLine();
        System.out.printf("Total Time: %8d μs\n", totalTime);
    }
    
    private static void printHorizontalLine() {
        System.out.println("----------------------------------------");
    }
    
    private static void printData(String result, long executionTimeInMicroseconds) {
        System.out.printf("%13s|", executionTimeInMicroseconds + " μs ");
        
        if (result != null) {
            System.out.printf("%13s\n", result);
        } else {
            System.out.println("Not implemented yet.");
        }
    }
}
