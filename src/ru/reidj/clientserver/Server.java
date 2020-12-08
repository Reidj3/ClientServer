package ru.reidj.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8200);
        while (true) {
            Socket clientSocket = serverSocket.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println(reader.readLine());

            reader.close();
            clientSocket.close();
        }
    }
}
