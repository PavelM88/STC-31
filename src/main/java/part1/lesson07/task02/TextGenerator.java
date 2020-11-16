package part1.lesson07.task02;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TextGenerator {

    Random random = new Random();

    public void getFiles(String path, int n, int size, String[] words, int probability) {
        for (int i = 0; i < n; i++) {
            try (FileWriter fw = new FileWriter(path + "FileName" + (i + 1) + ".txt", true)) {
                String tx = textGenerate(size, words);
                fw.write(tx);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод создания слова, длина слов от 1 буквы до 15 букв
     *
     * @return строку слова.
     */
    public String createWord() {
        int maxWordLength = 15;
        int minWordLength = 1;
        int wordLength = random.nextInt(maxWordLength) + minWordLength;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            sb.append(letter);
        }
        return sb.toString();
    }

    /**
     * Метод создания массива слов. Длина массива от 1 - 1000 слов.
     *
     * @return возвращает массив слов.
     */
    public String[] arrayWords() {
        int maxSize = 1000;
        int minSize = 1;
        int len = random.nextInt(maxSize) + minSize;
        String[] words = new String[len];
        for (int i = 0; i < words.length; i++) {
            words[i] = createWord();
        }
        return words;
    }

    /**
     * Метод создания предложения. Длина предложения от 1-15 слов.
     *
     * @param probability вероятность
     * @param words       массив слов
     * @return предложение.
     */
    public String createSentence(int probability, String[] words) {
        int maxWord = 15;
        int minWord = 1;
        int wordSentence = random.nextInt(maxWord) + minWord;
        String[] symbol = new String[]{".", "!", "?"};
        int symbolId = random.nextInt(symbol.length);
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < wordSentence; i++) {
            int rw = random.nextInt(words.length);
            if (i == 0) {
                sentence.append(words[rw].substring(0, 1).toUpperCase());
            } else if (i == wordSentence - 1) {
                sentence.append(words[rw]);
            } else {
                String[] punkt = new String[]{" ", ", ", " ", " "};
                int rndPunkt = random.nextInt(punkt.length);
                sentence.append(words[rw]).append(punkt[rndPunkt]);
            }
        }
        sentence.append(symbol[symbolId]);
        return sentence.toString();
    }

    /**
     * Метод создания абзаца. Абзац содержит от 1 до 20 предложений.
     *
     * @param words массив слов.
     * @return абзац
     */
    public String paragraphText(String[] words) {
        int maxSentence = 20;
        int minSentence = 1;
        int paragraph = random.nextInt(maxSentence) + minSentence;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraph; i++) {
            sb.append(createSentence(2, words)).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Метод создания текста.
     * @param size размер
     * @param words массив слов
     * @return текст
     */
    public String textGenerate(int size, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(paragraphText(words)).append("\n");
        }
        return sb.toString();
    }
}
