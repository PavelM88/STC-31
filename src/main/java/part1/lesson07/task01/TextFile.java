package part1.lesson07.task01;

import java.io.*;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TextFile {

    public Set<String> sortWordsAlphabet(String file) {
        SortedSet<String> stringSet = new TreeSet<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] word = line.replaceAll("\\s*(\\s|,|–|!|\\.)\\s*", " ")
                        .toLowerCase().split(" ");
                Collections.addAll(stringSet, word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringSet;
    }

    public void writingToFile(SortedSet<String> word, String newFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile, false))) {
            for (String str : word) {
                bw.write(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
