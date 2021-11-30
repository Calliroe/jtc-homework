package testing;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class RunTests {
    private int passes = 0;
    private int failures = 0;
    private int total;

    public static void run(Class clazz) {
        RunTests tests = new RunTests();
        Method[] methods = clazz.getDeclaredMethods();
        tests.runMethods(clazz, methods, Before.class);
        tests.runMethods(clazz, methods, Test.class);
        tests.total = tests.passes + tests.failures;
        tests.runMethods(clazz, methods, After.class);
        System.out.println("===============================================\n" +
                "Total tests run: " + tests.total + ", Passes: " + tests.passes + ", Failures: " + tests.failures +
                "\n===============================================");
    }

    public void runMethods(Class clazz, Method[] methods, Class annotationClass) {
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
        RunTests tests = new RunTests();
        Set<Class> classes = tests.findAllClassesUsingClassLoader(pack.getName());
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

    public Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
