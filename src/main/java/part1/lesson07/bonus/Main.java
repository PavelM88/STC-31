package part1.lesson07.bonus;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\stc-31\\src\\main\\java\\part1\\lesson07\\bonus\\encoding.txt";
        String newPath = "D:\\stc-31\\src\\main\\java\\part1\\lesson07\\bonus\\NewEncoding.txt";

        try (Reader in = new BufferedReader(new FileReader(filePath));
             Writer out = new OutputStreamWriter(new FileOutputStream(newPath, false), StandardCharsets.UTF_16)) {
            int a;
            while ((a = in.read()) != -1) {
                out.write(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
