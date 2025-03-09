package ec;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;

public record Quest(int questId) {
    
    private static final int YEAR = 2024;
    
    public Solver determineSolver() {
        final var classPath = determineClassPath();
        final var clazz = determineClass(classPath);
        final var constructor = getConstructor(clazz);
        return determineSolver(constructor);
    }
    
    private String determineClassPath() {
        final var innerDirectories = String.format("ec/year%d", YEAR);
        final var dayPackageName = innerDirectories.replace('/', '.');
        return String.format("%s.Quest%02d", dayPackageName, questId);
    }
    
    private static Class<?> determineClass(String classPath) {
        try {
            return Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static Constructor<?> getConstructor(Class<?> clazz) {
        try {
            return clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static Solver determineSolver(Constructor<?> executable) {
        try {
            return (Solver) executable.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String retrieveInput(int partId) {
        final var filename = createFilename(partId);
        
        try {
            return Files.readString(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private String createFilename(int partId) {
        return String.format("input/quest%02d_p%d.txt", questId, partId);
    }
}
