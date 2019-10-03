package starter.strings;

public class Task2 {

    private static boolean palindrom(String str) {
        return str.equals(new StringBuilder().append(str).reverse().toString());
    }

    //Написать метод, который проверяет является ли слово палиндромом
    public static void main(String[] args) {
        String check = "12221";
        System.out.println(palindrom(check));
    }
}