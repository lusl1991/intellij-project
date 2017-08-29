package com.softel.model.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class InvokeUtil {

    /**
     * 获取get方法名
     * @param object
     * @return
     */
    public static List<Method> getMethod(Object object){
        ArrayList<Method> list = new ArrayList<>();
        Class clazz = object.getClass();
        //获得属性
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            String name = field.getName();
            name = name.substring(0,1).toUpperCase() + name.substring(1);
            Method method;
            try {
                method = clazz.getMethod("get" + name);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
            list.add(method);
        }
        return list;
    }

    /**
     * 获取属性
     * @param object
     * @return
     */
    public static List<Field> getFields(Object object){
        ArrayList<Field> list = new ArrayList<>();
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            list.add(field);
        }
        return list;
    }
}
