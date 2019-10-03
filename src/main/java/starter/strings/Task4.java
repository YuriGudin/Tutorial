package starter.strings;

/*
Имеются две строки. Найти количество вхождений одной (являющейся
подстрокой) в другую
 */
public class Task4 {

    public static void main(String[] args) {
        String symbol = "A";
        String text = "AAAAA";
        System.out.println((text+" \0").split(symbol).length-1);
    }

}
