package testing;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class RunTests {
    public static void run(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        int passes = 0;
        int failures = 0;
        for (Method method : methods) {
            if (method.getAnnotation(Before.class) != null) {
                try {
                    method.invoke(clazz.newInstance());
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                try {
                    method.invoke(clazz.newInstance());
                    passes++;
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                    failures++;
                }
            }
        }
        int total = passes + failures;
        for (Method method : methods) {
            if (method.getAnnotation(After.class) != null) {
                try {
                    method.invoke(clazz.newInstance());
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("===============================================\n" +
                "Total tests run: " + total + ", Passes: " + passes + ", Failures: " + failures +
                "\n===============================================");
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
