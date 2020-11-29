package part1.lesson11.task01;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", Server.PORT);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new BufferedWriter(
                             new OutputStreamWriter(client.getOutputStream())
                     ), true
             )
        ) {
            while (true) {
                System.out.println("Enter text:");
                String word = reader.readLine();

                out.write(word + "\n");
                out.flush();

                String serverWord = in.readLine();
                System.out.println(serverWord);
                if ("exit".equals(word)){
                    System.out.println("Exit");
                    break;
                }
            }
        }
    }
}
