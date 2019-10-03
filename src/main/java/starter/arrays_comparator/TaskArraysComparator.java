package starter.arrays_comparator;

/*
 Дан​ ​массив​ ​строк​ ​(с​ ​консоли,​ ​или​ ​через​ ​параметры​ ​командной​ ​строки).​
 ​Выведете их​ ​все​ ​разными​ ​способами:
 -По​ ​алфавиту
 -По​ ​возрастанию​ ​длины
 -По​ ​количеству​ ​вхождений​ ​цифр​ ​в​ ​строку
 * Для​ ​сортировка​ ​используется​ ​Arrays.sort()​ ​с​ ​параметром​ ​Comparator.
 * Для​ ​вывода​ ​строк​ ​из​ ​массива​ ​можно​ ​использовать​ ​Arrays.toString().
 */

import java.util.Arrays;
import java.util.Comparator;

public class TaskArraysComparator {

    public static void main(String[] args) {

        args = new String[] {"ABC1D", "BBBAEFD", "AERDM", "ERHELLO", "OK1"};

        System.out.println("Исходный массив: "+Arrays.toString(args));

        //По​ ​алфавиту
        Arrays.sort(args, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("По алфавиту: "+Arrays.toString(args));

        //По​ ​количеству​ ​вхождений​ ​цифр​ ​в​ ​строку
        Arrays.sort(args, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int countDigit_o1=0;
                int countDigit_o2=0;

                for (int i = 0; i < o1.length(); i++) {
                    if (Character.isDigit(o1.charAt(i))) countDigit_o1++;
                }

                for (int i = 0; i < o2.length(); i++) {
                    if (Character.isDigit(o2.charAt(i))) countDigit_o2++;
                }

                return Integer.compare(countDigit_o1, countDigit_o2);
            }
        });

        System.out.println("По количеству вхождений цифр в строку: "+Arrays.toString(args));

        //По​ ​возрастанию​ ​длины
        Arrays.sort(args, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println("По возрастанию длины: "+Arrays.toString(args));
    }
}