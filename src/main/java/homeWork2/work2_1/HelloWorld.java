package homeWork2.work2_1;

import java.util.Arrays;

public class HelloWorld {
    static String word;
    static String[] word2 = new String[1];

    public static void main(String[] args) throws Exception {
        System.out.println(word.length());

        word2[1] = Arrays.toString(new String[]{word});
        System.out.println(Arrays.toString(word2));

        if (word == null) throw new Exception("Переменная равна null");
        System.out.println(word.length());

    }
}
