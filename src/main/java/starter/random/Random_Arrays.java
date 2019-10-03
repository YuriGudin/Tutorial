package starter.random;
/*
* Заполните массив случайным числами и выведете максимальное,
* минимальное и среднее значение
* */
import java.util.Scanner;

public class Random_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = scanner.nextInt();
        double arr[] = new double [len];

        double max = -1;
        double min = 1;
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random();
            if (arr[i]>max) max = arr[i];
            if (arr[i]<min) min = arr[i];
            sum+=arr[i];
            System.out.println("arr["+i+"] -> "+arr[i]);
        }

        System.out.println("\nМаксимальное: "+max);
        System.out.println("Минимальное: "+min);
        System.out.println("Среднее: "+sum/arr.length);
    }
}
