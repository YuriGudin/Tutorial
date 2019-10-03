package starter.strings;

import java.util.Arrays;

class Cypher {

    static String alph = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    int width;
    int height;
    int [] permutation;

    public int getIndex(char symb){

        for (int i = 0; i < alph.length(); i++) {
            if (symb==alph.charAt(i))
                return i+1;
            else continue;
        }
        return -1;
    }

    public Cypher(int height, String keyword) {
        this.width = keyword.length();
        this.height = height;
        permutation = new int[keyword.length()];
        for (int i = 0; i < permutation.length; i++)
            permutation [i] = getIndex(keyword.toUpperCase().charAt(i));

        int [] sortPermutation = Arrays.copyOf(permutation, permutation.length);
        Arrays.sort(sortPermutation);

        for (int i = 0; i < permutation.length ; i++) {
            for (int j = 0; j < sortPermutation.length; j++) {
                if (permutation[i]==sortPermutation[j]){
                    permutation[i]=j;
                }
            }
        }

        //System.out.println(Arrays.toString(permutation));
    }

    public String encryptText(String src)
    {
        src = src.toUpperCase();

        char[] res = new char[src.length()];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                res[i * width + j] = src.charAt(permutation[j] * height + i);
        return new String (res);
    }

    public  String decryptText(String src)
    {
        src = src.toUpperCase();
        char[] res = new char[src.length()];
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                res[permutation[i] * height + j] = src.charAt(j * width + i);
        return new String (res);
    }
}

public class Task7 {

    public static void main(String[] args) {

        String text = "врагбудетразбитприветмирр";
        String key = "памир";

        System.out.println("Исходное сообщение: " +text.toUpperCase());

        Cypher cypher = new Cypher(5, key);

        String cipherText = cypher.encryptText(text);
        System.out.println("Зашифрованное сообщение: " +cipherText);

        String plainText = cypher.decryptText(cipherText);
        System.out.println("Расшифрованное сообщение: " +plainText);
    }
}
