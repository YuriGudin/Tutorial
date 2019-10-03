package jcf.filter;

/*
Написать​ ​ метод​ ​ filter,​ ​ который​ ​ принимает​ ​ на​ ​ вход​ ​ массив​ ​
(любого​ ​ типа)​ ​ и реализацию​ ​абстрактного класса ​ filter​ ​ c ​ ​
методом​ ​ apply (Object​ ​ o),​ ​ чтобы​ ​ убрать​ ​ из​ ​ массива лишнее.
Проверьте как он работает на строках или других объектах.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Filter {
    abstract boolean applay(Object object);
}

public class Task_Filter {

    public <T> T [] filter (T [] objects, Filter filter)
    {
        List<T> list = new ArrayList<T>();
        for (int i = 0; i <objects.length ; i++)
            if (filter.applay(objects[i])) list.add( objects[i]);

        return  list.toArray((T[]) Arrays.copyOf(objects, objects.length));
    }

    public static void main(String[] args) {

        String[] strings = new String[] {"1", "2", "TEST", "TEST", "HELLO", "ABCD" };

        Filter filterStringContainsTest = new Filter() {
            @Override
            boolean applay(Object object) {
                return ((String) object).contains("TEST");
            }
        };

        Filter filter2 = new Filter() {
            @Override
            boolean applay(Object object) {
                return object.toString().contains("A");
            }
        };


        String [] objects1 = (new Task_Filter().filter(strings, filterStringContainsTest));
        String [] objects2 =  (new Task_Filter().filter(strings, filter2));

        System.out.println(Arrays.toString(objects1) );
        System.out.println(Arrays.toString(objects2) );
    }
}