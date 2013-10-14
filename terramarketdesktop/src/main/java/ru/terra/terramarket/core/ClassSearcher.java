package ru.terra.terramarket.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

/**
 * Класс используемый для поиска аннотированных классов
 */

public class ClassSearcher<T> {

    /**
     * Метод поиска аннотированных классов в
     * пакете @param packageName
     * по аннотации @param annotaion
     */
    @SuppressWarnings("unchecked")
    public List<T> load(String packageName, Class annotaion) {
        List<T> ret = new ArrayList<>();
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(annotaion);
        for (Class<?> c : annotated) {
            Object o = null;
            try {
                o = c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (o != null)
                ret.add((T) o);
        }
        return ret;
    }
}
