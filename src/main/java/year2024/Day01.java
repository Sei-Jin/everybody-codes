package year2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day01 {
    
    private static final String PART_ONE_FILENAME = "input/day01_p1.txt";
    
    public static void main(String[] args) {
        final var partOneInput = parsePartOne();
        solvePartOne(partOneInput);
    }
    
    private static String parsePartOne() {
        try {
            return Files.readString(Path.of(PART_ONE_FILENAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void solvePartOne(String input) {
        var potions = 0;
        
        for (var i = 0; i < input.length(); i++) {
            final var character = input.charAt(i);
            
            switch (character) {
                case 'A' -> potions += 0;
                case 'B' -> potions += 1;
                case 'C' -> potions += 3;
            }
        }
        
        System.out.println(potions);
    }
}