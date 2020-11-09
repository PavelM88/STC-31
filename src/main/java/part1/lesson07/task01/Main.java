package part1.lesson07.task01;


import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {
        TextFile textFile = new TextFile();
        String file = "D:\\stc-31\\src\\main\\java\\part1\\lesson07\\task01\\text.txt";
        String newFile = "D:\\stc-31\\src\\main\\java\\part1\\lesson07\\task01\\SortText.txt";
        SortedSet<String> text = (SortedSet<String>) textFile.sortWordsAlphabet(file);

        textFile.sortWordsAlphabet(file);
        textFile.writingToFile(text, newFile);
    }
}
