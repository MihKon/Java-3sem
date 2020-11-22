package pract19_20;

import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Client {
    private static String name;
    //private static int port = 2859;
    private static DatagramSocket socket;
    private static Scanner scan = new Scanner(System.in);
    static {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Введите имя пользователя: ");
        DatagramSocket socket = new DatagramSocket();
        Thread input = new Thread(() -> {
            name = scan.nextLine();
            try {
                socket.send(new DatagramPacket(name.getBytes(), 0, name.length(), InetAddress.getByName("127.0.0.1"), 2859));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println("Отлично, " + name + ". Общайтесь!");
            while (true){
                DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                ZoneId zone = ZoneId.of("Europe/Moscow");
                LocalDateTime date = LocalDateTime.now(zone);
                String time = f.format(date);
                String message = scan.nextLine();

                String chatMessage = time + " | "  + name + ": " + message;

                byte[] data = chatMessage.getBytes();
                DatagramPacket packetToSend;

                try {
                    packetToSend = new DatagramPacket(data, 0, data.length, InetAddress.getByName("127.0.0.1"), 2859);
                    socket.send(packetToSend);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread output = new Thread(() -> {
            while (true) {
                byte[] buffer = new byte[2048];
                DatagramPacket packetToReceive = new DatagramPacket(buffer, 0, buffer.length);
                try {
                    socket.receive(packetToReceive);
                    System.out.println(new String(packetToReceive.getData(), 0, packetToReceive.getLength()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        input.start();
        output.start();

        /*while (true) {
            String message = scan.nextLine();
            chatting(message);
        }*/
    }

    /*public static void chatting(String message) throws IOException {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        ZoneId zone = ZoneId.of("Europe/Moscow");
        LocalDateTime date = LocalDateTime.now(zone);
        String time = f.format(date);

        String chatMessage = time + " | "  + name + ": " + message;

        byte[] data = chatMessage.getBytes();
        DatagramPacket packetToSend = new DatagramPacket(data, 0, data.length, InetAddress.getByName("127.0.0.1"), 2859);
        socket.send(packetToSend);

        byte[] buffer = new byte[2048];
        DatagramPacket packetToReceive = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packetToReceive);

        System.out.println(new String(packetToReceive.getData(), 0, packetToReceive.getLength()));
    }*/
}
