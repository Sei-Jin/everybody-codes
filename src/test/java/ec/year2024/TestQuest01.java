package ec.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuest01 {
    
    private static final Quest01 QUEST = new Quest01();
    
    @Test
    void testPart1() {
        final var input = "ABBAC";
        assertEquals(5, QUEST.solvePart1(input));
    }
    
    @Test
    void testPart2() {
        final var input = "AxBCDDCAxD";
        assertEquals(28, QUEST.solvePart2(input));
    }
    
    @Test
    void testPart3() {
        final var input = "xBxAAABCDxCC";
        assertEquals(30, QUEST.solvePart3(input));
    }
}
