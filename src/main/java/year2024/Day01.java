package year2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day01 {
    
    private static final String PART_ONE_FILENAME = "input/day01_p1.txt";
    
    private static String parseInput() {
        try {
            return Files.readString(Path.of(PART_ONE_FILENAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static List<Creature> parsePartOne(String input) {
        final var list = new ArrayList<Creature>();
        
        for (int i = 0; i < input.length(); i++) {
            final var character = input.charAt(i);
            final var creature = Creature.creatureMap.get(character);
            list.add(creature);
        }
        
        return list;
    }
    
    private static int solvePartOne(List<Creature> creatures) {
        return creatures
            .stream()
            .mapToInt(creature -> creature.potionsRequired)
            .sum();
    }
    
    private enum Creature {
        
        ANCIENT_ANT(0),
        BADASS_BEETLE(1),
        CREEPY_COCKROACH(3);
        
        private final int potionsRequired;
        
        Creature(int potionsRequired) {
            this.potionsRequired = potionsRequired;
        }
        
        private static final Map<Character, Creature> creatureMap = Creature.createCreatureMap();
        
        private static Map<Character, Creature> createCreatureMap() {
            final var creatureMap = new HashMap<Character, Creature>();
            
            creatureMap.put('A', ANCIENT_ANT);
            creatureMap.put('B', BADASS_BEETLE);
            creatureMap.put('C', CREEPY_COCKROACH);
            
            return creatureMap;
        }
    }
    
    public static void main(String[] args) {
        final var input = parseInput();
        
        final var creatures = parsePartOne(input);
        final var partOne = solvePartOne(creatures);
        
        System.out.println(partOne);
    }
}