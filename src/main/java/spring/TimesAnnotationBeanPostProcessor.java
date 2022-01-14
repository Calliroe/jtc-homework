package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

@Component
public class TimesAnnotationBeanPostProcessor implements BeanPostProcessor {
    private final Map<Class<?>, List<Method>> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        for (Method method : methods) {
            Times annotation = method.getAnnotation(Times.class);
            if (annotation != null) {
                list.add(method);
            }
        }
        if (!list.isEmpty()) map.put(bean.getClass(), list);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(bean.getClass())) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                Method original = null;
                for (Method m : map.get(bean.getClass())) {
                    if (theSameSignature(m, method)) original = m;
                }
                if (original != null) {
                    int count = original.getDeclaredAnnotation(Times.class).count();
                    if (count > 0) {
                        Object object = method.invoke(bean, args);
                        for (int i = 0; i < count - 1; i++) {
                            method.invoke(bean, args);
                        }
                        return object;
                    } else return null;
                }
                return method.invoke(bean, args);
            });
        }
        return bean;
    }

    private static boolean theSameSignature(Method method1, Method method2) {
        return (method1.getName().equals(method2.getName()) && Arrays.equals(method1.getParameterTypes(), method2.getParameterTypes()));
    }
}

