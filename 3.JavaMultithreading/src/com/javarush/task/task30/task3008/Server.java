package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap();

    public static void sendBroadcastMessage(Message message) {
        connectionMap.values().forEach(v -> {
            try {
                v.send(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter server port");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен!");
            Socket socket = null;
            try {
                while (true) {
                    socket = serverSocket.accept();
                    new Handler(socket).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                assert socket != null;
                socket.close();
            }
        } catch (IOException e) {
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST, "What is your name?"));
            Message response = connection.receive();
            if (response.getType() == MessageType.USER_NAME) {
                String name = response.getData();
                if (!name.isEmpty() && !connectionMap.containsKey(name)) {
                    connectionMap.put(name, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return name;
                }
            }
            return serverHandshake(connection);
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String n : connectionMap.keySet()) {
                if (!n.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, n));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else ConsoleHelper.writeMessage("Wrong message type");
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("New connection with " + socket.getRemoteSocketAddress());
            String name = null;
            try (Connection connection = new Connection(socket)) {
                name = serverHandshake(connection);
                connectionMap.put(name, connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                notifyUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (name != null) {
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                    ConsoleHelper.writeMessage("Connection with remote socket closed");
                }
            }
        }
    }
}
