package ec;

import java.util.ArrayList;

public class Runner {
    
    public static ArrayList<ExecutionData> run(Quest quest) {
        final var solver = quest.determineSolver();
        
        final var data = new ArrayList<ExecutionData>();
        data.add(runPart(Part.ONE, solver, quest.retrieveInput(1)));
        data.add(runPart(Part.TWO, solver, quest.retrieveInput(2)));
        data.add(runPart(Part.THREE, solver, quest.retrieveInput(3)));
        
        return data;
    }
    
    private static ExecutionData runPart(Part part, Solver solver, String input) {
        final var startTime = System.nanoTime();
        
        final var result = switch (part) {
            case Part.ONE -> solver.solvePart1(input).toString();
            case Part.TWO -> solver.solvePart2(input).toString();
            case Part.THREE -> solver.solvePart3(input).toString();
        };
        
        final var endTime = System.nanoTime();
        final var executionTimeInMicroseconds = (endTime - startTime) / 1000;
        
        return new ExecutionData(part.name(), result, executionTimeInMicroseconds);
    }
    
    private enum Part {
        ONE, TWO, THREE
    }
}
