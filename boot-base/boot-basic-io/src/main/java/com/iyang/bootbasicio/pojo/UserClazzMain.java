package com.iyang.bootbasicio.pojo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-28
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class UserClazzMain {

    public static void main(String[] args) throws Exception {

/*
        User u = new User();

        Annotation[] annotations = u.getClass().getAnnotations();
        System.out.println(Arrays.asList(annotations).toString());
        GavinYang gavinYang = u.getClass().getAnnotation(GavinYang.class);
        System.out.println(gavinYang.toString());

        Field field = u.getClass().getDeclaredField("name");
        Annotation[] fieldAnnotations = field.getAnnotations();
        System.out.println(Arrays.asList(fieldAnnotations).toString());
*/


        UserService u  = new UserService();
        Field[] fields = u.getClass().getDeclaredFields();
        for(Field f : fields){
            GavinYangAutowired autowired = f.getDeclaredAnnotation(GavinYangAutowired.class);
            if(autowired != null){
                Class<?> fType = f.getType();
                Constructor<?> typeConstructor = fType.getConstructor();
                Object instance = typeConstructor.newInstance();

                f.setAccessible(true);
                f.set(u,instance);
            }
        }

        u.hello();

        //Field[] fields = u.getClass().getFields();
        //System.out.println(Arrays.asList(fields).toString());
        //获取字段,私有的不能获取,会抛出异常
        //Field field = u.getClass().getField("age");
        //System.out.println(field.toString());

       // Field[] declaredFields = u.getClass().getDeclaredFields();
        //System.out.println(Arrays.asList(declaredFields).toString());

       // Field name = u.getClass().getDeclaredField("name");
       // System.out.println(name.toString());


        // Method[] methods = u.getClass().getMethods();
        // System.out.println(Arrays.asList(methods).toString());

        //ClassLoader classLoader = u.getClass().getClassLoader();
        // Method method = u.getClass().getMethod("say");
        //Method[] declaredMethods = u.getClass().getDeclaredMethods();
        //System.out.println(Arrays.asList(declaredMethods).toString());
        //Method say = u.getClass().getDeclaredMethod("say");
        //say.invoke(classLoader);
        //System.out.println(say.toString());
        //method.invoke(classLoader);
        // Method say = u.getClass().getDeclaredMethod("say");
        //Method say = classLoader.getClass().getDeclaredMethod("say");
        // say.invoke(u);
    }

}
