package part1.lesson11.task01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static final int PORT = 8000;

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(PORT);
        System.out.println("Start Server!");
        Socket clientSocket = socket.accept();
        while (true) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(
                         new BufferedWriter(
                                 new OutputStreamWriter(clientSocket.getOutputStream())
                         ), true
                 )
            ) {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);

                    out.write("Hello, this is server!" + "\n");
                    out.flush();
                }
            }
        }
    }
}
