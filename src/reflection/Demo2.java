package reflection;

import java.lang.reflect.Field;

public class Demo2 {


    public static void main(String[] args) {

        Person person1 = new Person("albert");
        Person person2 = new Person("sara");
        Field[] fields2 = person1.getClass().getDeclaredFields();
        Class<?> PersonClass1 = person1.getClass();
        Class<?> PersonClass2 = person2.getClass();
        if(PersonClass1.equals(PersonClass2)){
            System.out.println("ens objekter");
        }else {
            System.out.println("forskellige objekter");
        }

        for (Field field : fields2) {
            try {
                field.setAccessible(true);
                System.out.println("navn: " + field.get(person2));
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }


//        Object myString = "Hello World!";
//
//        Class<?> myStringClass = myString.getClass();
//
//        System.out.println("the class name is:");
//        System.out.println(myStringClass.getSimpleName());

        Class class1 = Class.class;
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            //System.out.println(field.getName() + " : " + field.get());
        }


    }
}
