package starter.primeNumbers;
/*
   Напишите программу, которая вычислит простые числа в пределах от 2 до 100.
 */
public class PrimeNumbers {

    public static void main(String[] args) {

        int n = 100;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            int q = (int) Math.sqrt(i);
            for (int j = 2; j <= q; j++) {
                if ((i % j) == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                System.out.print(i + " ");

        }

    }

}
