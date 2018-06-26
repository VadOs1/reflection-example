package com.annot;

import java.lang.reflect.Method;

public class Tester {
    public static boolean test(Class<?>... ls) {
        try {
            for (Class<?> cls : ls) {
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Test.class)) {
                        Test t = method.getAnnotation(Test.class);
                        System.out.println(t.testText());
                        Boolean b = (Boolean) method.invoke(null, new Object[]{});
                        if (!b)
                            return false;
                    }
                }
            }
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
