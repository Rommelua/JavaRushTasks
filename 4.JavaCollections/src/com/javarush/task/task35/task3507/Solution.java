package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        //Set<? extends Animal> allAnimals = getAllAnimals("D:\\Java\\JavaRush\\JavaRushTasks\\out\\production\\4.JavaCollections\\com\\javarush\\task\\task35\\task3507/data");
        System.out.println(allAnimals);
    }

    private static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Path directory = Paths.get(pathToAnimals);
        List<Path> classes = new ArrayList<>();
        try {
            classes = Files.walk(directory, 1)
                    .filter(Files::isRegularFile)
                    .filter(e -> e.toString().endsWith(".class")).collect(Collectors.toList());
        } catch (IOException e) {        }
        Set<Animal> resultSet = new HashSet<>();
        for (Path clazz : classes) {
            MyClassLoader loader = new MyClassLoader();
            Class<?> loadedClass = loader.getClassFromFile(clazz);
            if (loadedClass == null) continue;
            Constructor<?> constructor = null;
            try {
                constructor = loadedClass.getConstructor();
            } catch (NoSuchMethodException e) {}
            if (Animal.class.isAssignableFrom(loadedClass) && constructor != null) {
                try {
                    resultSet.add((Animal) constructor.newInstance());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {}
            }
        }
        return resultSet;
    }

    static class MyClassLoader extends ClassLoader {
        public Class getClassFromFile(Path file) {
            try {
                byte[] bytes = Files.readAllBytes(file);
                return defineClass(null, bytes, 0, bytes.length);
            } catch (IOException e) {
                return null;
            }
        }
    }
//    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
//        String packageName = Solution.class.getPackage().getName() + ".data";//pathToAnimals.substring(pathToAnimals.indexOf("/com") + 1).replaceAll("/", ".");
//        Set<Animal> result = new HashSet<>();
//        File[] files = new File(pathToAnimals).listFiles();
//        for (File file : files) {
//            Class clazz = new DynamicClassLoader().load(file.toPath(), packageName);
//            int score = 0;
//            Class[] interfaces = clazz.getInterfaces();
//            for (Class c : interfaces) {
//                if (c.getSimpleName().contains("Animal")) {
//                    score++;
//                    break;
//                }
//            }
//            Constructor[] constructors = clazz.getConstructors();
//            for (Constructor constructor : constructors) {
//                if (constructor.getParameterCount() == 0) {
//                    score++;
//                }
//            }
//            try {
//                if (score == 2) {
//                    Animal animal = (Animal) clazz.newInstance();
//                    result.add(animal);
//                }
//            } catch (InstantiationException | IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//    public static class DynamicClassLoader extends ClassLoader {
//        public Class<?> load(Path path, String packageName) {
//            try {
//                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
//                byte[] buffer = Files.readAllBytes(path);
//                return defineClass(className, buffer, 0, buffer.length);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }

}
