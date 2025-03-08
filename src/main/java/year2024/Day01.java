package year2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day01 {
    
    private static final String filename = "input/day01_p1.txt";
    
    public static void main(String[] args) {
        final var input = readInput();
        
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
    
    private static String readInput() {
        try {
            return Files.readString(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}