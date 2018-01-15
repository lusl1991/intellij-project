package com.softel.model.utils;

import com.softel.model.Merchant;
import org.apache.poi.util.SystemOutLogger;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @author: lsl
 * @description:
 * @date: Created in 15:51 2017/11/23
 * @modified By:
 */
public class ReflectObj {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IntrospectionException {
        Class<Merchant> contactItem = Merchant.class;
        Field[] fields = contactItem.getDeclaredFields();
        Map<String, String> map = new HashMap<String, String>();
        for (Field field : fields) {
            String name = field.getName();
            PropertyDescriptor pd=new PropertyDescriptor(name,contactItem);
            Method getMethod = pd.getReadMethod();
            String method = getMethod.getName();
            map.put(name, method);
        }
    }
}
