package reflection;

import java.lang.reflect.Field;

public class GetName {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name);
        Class<? extends Person> clazz = person.getClass();
        try {
//            Field field = clazz.getSuperclass().getDeclaredField("name");
//            Field field = clazz.getField("name");
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(person, "newborn");
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(person.name);
    }
}

class Person {
    String name ;//= "a";
//    public String getName(){
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
