/*
*  Заполните массив случайным числами и отсортируйте его.
   Используйте сортировку пузырьком.
* */
package starter.bubbleSort;
import java.util.Scanner;
public class BubbleSort {

    public static void bubbleSort(double[] arr){ /*Сравниваем элементы попарно, если они имеют неправильный порядок, то меняем местами*/
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr[j] > arr[j+1] ){
                    double tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = scanner.nextInt();
        double arr[] = new double [len];

        //Заполнение массива случайными числами
        for (int i = 0; i <arr.length; i++) {
            arr[i] = Math.random();
            System.out.println("arr["+i+"] -> "+arr[i]);
        }

        //Сортировка пузырьком
        bubbleSort(arr);
        System.out.println("После сортировки:");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"] -> "+arr[i]);
        }
}
}
