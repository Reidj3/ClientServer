package ru.reidj.clientserver.client;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends JFrame {
    private final JTextArea log = new JTextArea();
    private final JTextField fieldInput = new JTextField();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Client();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private Client() throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8200);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        log.setEditable(false);
        log.setLineWrap(true);

        add(log, BorderLayout.CENTER);
        fieldInput.addActionListener(e -> {
            try {
                OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
                writer.write(fieldInput.getText());
                writer.flush();
                log.append(fieldInput.getText() + "\n");
                fieldInput.setText(null);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        add(fieldInput, BorderLayout.SOUTH);

        setVisible(true);
    }
}

