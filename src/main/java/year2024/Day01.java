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
    private static final String PART_TWO_FILENAME = "input/day01_p2.txt";
    
    private static List<Creature> parseCreatures(String filename) {
        final var list = new ArrayList<Creature>();
        final var input = parseInput(filename);
        
        for (int i = 0; i < input.length(); i++) {
            final var character = input.charAt(i);
            final var creature = Creature.creatureMap.get(character);
            list.add(creature);
        }
        
        return list;
    }
    
    private static String parseInput(String filename) {
        try {
            return Files.readString(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static int solvePartOne(List<Creature> creatures) {
        return creatures
            .stream()
            .mapToInt(creature -> creature.potionsRequired)
            .sum();
    }
    
    private static int solvePartTwo(List<Creature> creatures) {
        var potions = 0;
        
        for (int i = 0; i < creatures.size(); i += 2) {
            var potionPair = 0;
            
            final var first = creatures.get(i);
            final var second = creatures.get(i + 1);
            
            if (first != Creature.EMPTY && second != Creature.EMPTY) {
                potionPair += 1;
                potionPair += 1;
            }
            
            potionPair += first.potionsRequired;
            potionPair += second.potionsRequired;
            
            potions += potionPair;
        }
        
        return potions;
    }
    
    private enum Creature {
        
        EMPTY(0),
        ANCIENT_ANT(0),
        BADASS_BEETLE(1),
        CREEPY_COCKROACH(3),
        DIABOLICAL_DRAGONFLY(5);
        
        private final int potionsRequired;
        
        Creature(int potionsRequired) {
            this.potionsRequired = potionsRequired;
        }
        
        private static final Map<Character, Creature> creatureMap = Creature.createCreatureMap();
        
        private static Map<Character, Creature> createCreatureMap() {
            final var creatureMap = new HashMap<Character, Creature>();
            
            creatureMap.put('x', EMPTY);
            creatureMap.put('A', ANCIENT_ANT);
            creatureMap.put('B', BADASS_BEETLE);
            creatureMap.put('C', CREEPY_COCKROACH);
            creatureMap.put('D', DIABOLICAL_DRAGONFLY);
            
            return creatureMap;
        }
    }
    
    public static void main(String[] args) {
        final var partOne = solvePartOne(parseCreatures(PART_ONE_FILENAME));
        final var partTwo = solvePartTwo(parseCreatures(PART_TWO_FILENAME));
        
        System.out.println(partOne);
        System.out.println(partTwo);
    }
}