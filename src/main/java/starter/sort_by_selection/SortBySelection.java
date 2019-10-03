package starter.sort_by_selection;
/*
Реализовать сортировку выбором
*/
public class SortBySelection {

    //Сортировка выбором
    /*
    Шаги алгоритма:
    1. находим номер минимального значения в текущем списке
    2. производим обмен этого значения со значением первой неотсортированной
    позиции (обмен не нужен, если минимальный элемент уже находится на данной
    позиции)
    3. теперь сортируем хвост списка, исключив из рассмотрения уже
    отсортированные элементы.
     */
    static void sortByChoice(double [] numbers){
        int min;
        double temp;

        for (int index = 0; index < numbers.length-1; index++){
            min = index;
            for (int scan = index+1; scan < numbers.length; scan++){
                if (numbers[scan] < numbers[min])
                    min = scan;
            }

            temp = numbers[min];
            numbers[min] = numbers[index];
            numbers[index] = temp;
        }
    }
    public static void main(String[] args) {

        double[] array = new double[10000];

        for (int i = 0; i <array.length; i++) {
            array[i] = Math.random();
            //System.out.print(array[i]+" ");
        }

        long start = System.currentTimeMillis();
        sortByChoice(array);
        long stop = System.currentTimeMillis();
        System.out.println("Время выполнения алгоритма: "+(stop-start));

        for (int i = 0; i <array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
