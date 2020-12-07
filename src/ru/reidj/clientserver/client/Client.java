package ru.reidj.clientserver.client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8200);

        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

        writer.write("Отправляю сообщение на сервер\n");
        writer.flush();

        System.out.println(reader.readLine());

        reader.close();
        writer.close();
        clientSocket.close();
    }
}
