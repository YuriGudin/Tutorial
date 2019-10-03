package starter.filter;

/*
 Написать​ ​метод​ ​filter,​ ​которые​ ​принимает​ ​на​ ​вход​ ​массив​ ​(любого​ ​типа)​
 ​и реализацию​ ​интерфейса​ ​filter​ ​c​ ​методом​ ​apply(Object​ ​o),​ ​
 чтобы​ ​убрать​ ​из​ ​массива лишнее.

 */
interface Filterable {
    boolean applay(Object object);
}

public class Task_Filterable {

    public static Object[] filter (Object[] objects, Filterable filterable)
    {
        Object[] filterObjects = new Object[objects.length];

        int counter = 0;
        for (int i = 0; i < objects.length; i++) {
            if (filterable.applay(objects[i])) {
                filterObjects[counter] = objects[i];
                counter++;
            }
        }

        Object[] filterObjects2 = new Object[counter];
        for (int i = 0; i <filterObjects2.length ; i++)
            filterObjects2[i] = filterObjects[i];

        return filterObjects2;
    }

    public static void main(String[] args) {

        String[] strings = new String[] {"1", "2", "TEST", "TEST", "HELLO", "ABCD" };

        Object[] stringsFilter = filter(strings, new Filterable() {
            @Override
            public boolean applay(Object object) {
                String string = (String) object;
                return string.contains("A");
            }
        });

        for (int i = 0; i <stringsFilter.length ; i++) {
            String temp = (String) stringsFilter[i];
            System.out.println(temp);
        }

    }
}