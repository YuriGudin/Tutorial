package starter.strings;

/*
Напишите метод, заменяющий в тексте все вхождения слова «бяка» на «[вырезано
цензурой].
 */
public class Task3 {

    public  static  String censour(String string){
        String censorText = "бяка";
        return string.replaceAll(censorText, "[вырезано цензурой]");
    }
    public static void main(String[] args) {

        String text = new String("Сайт рыбатекст бяка дизайнеру, верстальщику, вебмастеру сгенерировать несколько абзацев более менее осмысленного текста рыбы на русском языке, а начинающему оратору отточить навык публичных выступлений в домашних условиях. При создании генератора мы использовали небезизвестный универсальный код речей. Текст генерируется абзацами случайным образом от двух до десяти предложений в абзаце, что позволяет сделать текст более привлекательным и живым для визуально-слухового восприятия."+
                "По своей бяка рыбатекст является бяка традиционному lorem ipsum, который вызывает у некторых людей недоумение при попытках прочитать рыбу текст. В отличии от lorem ipsum, текст рыба на русском языке наполнит любой макет непонятным смыслом и придаст неповторимый колорит советских времен.");


        System.out.println("Исходный текст: \n");
        System.out.println(text);

        System.out.println("Преобразованный текст: ");
        System.out.println(censour(text));
    }

}