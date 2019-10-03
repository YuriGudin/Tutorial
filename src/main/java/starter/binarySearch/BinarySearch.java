package starter.binarySearch;
/*
Написать метод, который проверяет, входит ли в сортированный массив
заданный элемент или нет.
Используйте перебор и двоичный поиск для решения этой задачи.
Сравните время выполнения обоих решений для больших массивов
(например, 100000 элементов).
 */

public class BinarySearch {

    //Перебор
    static boolean checkBrute(int value, int [] sortArray){
        for (int i = 0; i <sortArray.length ; i++)
            if (value == sortArray[i])
                return true; //Элемент найден

        return false; //Элемент не найден
    }

    //Двоичный поиск
    static boolean checkBinarySearch( int value, int[] a) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == value)
                return true;
            if (a[m] < value)
                l = m + 1;
            else
                r = m - 1;
        }
        return false;
    }

    public static void main(String[] args) {

        int [] array = new int[100000];
        for (int i = 0; i <array.length ; i++) {
            array[i] = i;
            //System.out.print(array[i]+" ");
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i <100000 ; i++) {
            checkBrute(999999, array);
        }

        long stop  = System.currentTimeMillis();
        System.out.println(stop-start);

        start = System.currentTimeMillis();
        for (int i = 0; i <100000 ; i++) {

            checkBinarySearch(999999, array);
        }

        stop  = System.currentTimeMillis();
        System.out.println(stop-start);
    }

}
