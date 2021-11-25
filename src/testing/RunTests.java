package testing;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class RunTests { // Заменить статики
    private static int passes = 0;
    private static int failures = 0;

    public static void run(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        runMethods(clazz, methods, Before.class);
        runMethods(clazz, methods, Test.class);
        int total = passes + failures;
        runMethods(clazz, methods, After.class);
        System.out.println("===============================================\n" +
                "Total tests run: " + total + ", Passes: " + passes + ", Failures: " + failures +
                "\n===============================================");
        passes = failures = 0;
    }

    public static void runMethods(Class clazz, Method[] methods, Class annotationClass) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                try {
                    method.invoke(clazz.getDeclaredConstructor().newInstance());
                    if (annotationClass.equals(Test.class)) passes++;
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                    e.printStackTrace();
                    if (annotationClass.equals(Test.class)) failures++;
                }
            }
        }
    }

    public static void run(Package pack) {
        Set<Class> classes = findAllClassesUsingClassLoader(pack.getName());
        for (Class clazz : classes) {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.getAnnotation(Test.class) != null) {
                    run(clazz);
                    break;
                }
            }
        }
    }

    public static Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
