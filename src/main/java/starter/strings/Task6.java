package starter.strings;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
* Постройте частотный словарь букв русского (или английского) алфавита.
(опустим проблему выбора и анализа корпуса языка, достаточно будет взять текст
небольшой длины).
Для чтения текста из файла можно использовать такую конструкцию:
String content = new String(Files.readAllBytes(Paths.get("readMe.txt")), "UTF-8");

 */
public class Task6 {

    public static String uniqueCharacters(String input)
    {
        String unique = input.replaceAll("(?i)(.)(?=.*?\\1)", "");
        return unique;
    }

    public  static int countSymb(String input, char symbol){
        String str = input;
        char[] symb = str.toCharArray();
        int count = 0;
        for(int i = 0; i < symb.length; ++i)
            if(symb[i] == symbol)
                ++count;
        return count;
    }

    public static void main(String[] args) {

        try {
            String content = new String(Files.readAllBytes(Paths.get("readMe.txt")), "UTF-8");
            content = content.toLowerCase().trim();
            String alph =(uniqueCharacters(content));
            System.out.println(alph);

            for (int i = 0; i < alph.length(); i++) {
                System.out.println(alph.charAt(i)+" = "+countSymb(content, alph.charAt(i)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
