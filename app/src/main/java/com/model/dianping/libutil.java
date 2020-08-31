package com.model.dianping;

import android.os.Build;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * libutil
 */
public class libutil {


    public static boolean a(String str, Class cls) {
        Object[] objArr = {str, cls};

        try {
            ClassLoader classLoader = cls.getClassLoader();
            Class<?> cls2 = Runtime.getRuntime().getClass();
            Class[] clsArr = new Class[2];
            if (Build.VERSION.SDK_INT > 24) {
                clsArr[0] = ClassLoader.class;
                clsArr[1] = String.class;
                Method declaredMethod = cls2.getDeclaredMethod("loadLibrary0", clsArr);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(Runtime.getRuntime(), new Object[]{classLoader, str});
            } else {
                clsArr[0] = String.class;
                clsArr[1] = ClassLoader.class;
                Method declaredMethod2 = cls2.getDeclaredMethod("loadLibrary", clsArr);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(Runtime.getRuntime(), new Object[]{str, classLoader});
            }
            return true;
        } catch (IllegalAccessException e) {

            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e2) {

            return false;
        } catch (NoSuchMethodException e3) {

            e3.printStackTrace();
            return false;
        }
    }
}
