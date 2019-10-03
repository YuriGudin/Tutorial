package starter.strings;

/*
Напишите метод, который инвертирует слова в строке. Предполагается, что в
строке нет знаков препинания, и слова разделены пробелами.
Sample Output:
The given string is: This is a test string
The string reversed word by word is:
sihT si a tset gnirts
 */
public class Task5 {

    static  String revereString (String string)
    {
        char array[] = string.toCharArray();

        for (int i = 0; i < array.length / 2; i++) {
            char tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        String reverceString = new String(array);
        return reverceString;
    }

    static String reverceText (String text){
        String [] strings = text.split(" ");
        String stringBuilder = "";

        for (int i = 0; i < strings.length; i++) {
            stringBuilder = stringBuilder + revereString(strings[i]) + " ";
        }

        return stringBuilder;
    }

    public static void main(String[] args) {
        String string = "This is a test string";
        System.out.println(reverceText(string));
    }
}
