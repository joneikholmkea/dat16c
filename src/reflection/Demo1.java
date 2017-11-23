package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo1 {


    public static void main(String[] args) {


        Object aString = new String("hello world");

        Class sStringClass = aString.getClass();

        Field[] fields = sStringClass.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].toString());
        }

        Method[] methods = sStringClass.getDeclaredMethods();
        System.out.println();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].toString());
        }

    }



}
