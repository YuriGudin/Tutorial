package starter.scan;

import java.util.Scanner;

/*Найти алгебраическую сумму для выражения: 1 k + 2 k + 3 k + … + N k . N и степень k вводит пользователь.
*/
public class Scan {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите N: ");
        int n = scanner.nextInt();
        System.out.print("Введите k: ");
        int k = scanner.nextInt();

        System.out.println("N = "+n);
        System.out.println("k = "+k);

        long sum=0;
        for (int i = 1; i < n; i++)
            sum+=Math.pow(i,k);

        System.out.println("Сумма: "+sum);

    }
}
