package com.javarush.task.task36.task3606;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        Path packagePath = Paths.get(packageName);
        MyClassLoader myClassLoader = new MyClassLoader();
        try {
            Files.walk(packagePath).filter((e -> e.toString().endsWith(".class")))
                    .map(myClassLoader::getClassFromFile)
                    .filter(HiddenClass.class::isAssignableFrom)
                    .forEach(hiddenClasses::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return (HiddenClass) constructor.newInstance();
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
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
}

