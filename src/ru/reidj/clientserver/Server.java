package ru.reidj.clientserver;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

            Socket clientSocket = serverSocket.accept();
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write("<h1>Hello World</h1>");
            writer.flush();
            writer.close();

            clientSocket.close();
    }
}
