package ec.year2024;

import ec.Main;
import ec.Solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quest01 implements Solver {
    
    private static List<Creature> parseCreatures(String input) {
        final var list = new ArrayList<Creature>();
        
        for (int i = 0; i < input.length(); i++) {
            final var character = input.charAt(i);
            final var creature = Creature.creatureMap.get(character);
            list.add(creature);
        }
        
        return list;
    }
    
    private static int solve(List<Creature> creatures, int maxGroupSize) {
        var totalPotions = 0;
        
        for (int i = 0; i < creatures.size(); i += maxGroupSize) {
            var groupPotions = 0;
            
            final var groupCreatures = new ArrayList<Creature>();
            
            for (int j = 0; j < maxGroupSize; j++) {
                final var creature = creatures.get(i + j);
                
                if (creature != Creature.EMPTY) {
                    groupCreatures.add(creature);
                }
            }
            
            final var bonus = groupCreatures.size() - 1;
            
            for (final var creature : groupCreatures) {
                groupPotions += creature.potionsRequired + bonus;
            }
            
            totalPotions += groupPotions;
        }
        
        return totalPotions;
    }
    
    @Override
    public Integer solvePart1(String input) {
        final var creatures = parseCreatures(input);
        return solve(creatures, 1);
    }
    
    @Override
    public Integer solvePart2(String input) {
        final var creatures = parseCreatures(input);
        return solve(creatures, 2);
    }
    
    @Override
    public Integer solvePart3(String input) {
        final var creatures = parseCreatures(input);
        return solve(creatures, 3);
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
        Main.runAndPrint(1);
    }
}