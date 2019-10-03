package starter.strings;

public class Task1 {

    static int search (String[] strings)
    {
        int maxIndex = 0;
        int maxLen = 0;
        for (int i = 0; i <strings.length ; i++) {
            if (maxLen<=strings[i].length()){
                maxLen = strings[i].length();
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public static void main(String[] args) {
        String [] strings = {"ABC", "ABCD", "ABCDE", "ABCDEF"};

        int maxIndex = search(strings);
        System.out.println("Самая длинная строка: "+strings[maxIndex]+" "+strings[maxIndex].length());
    }
}
