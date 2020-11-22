package pract19_20;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args) {
        try {
            ArrayList<Integer> ports = new ArrayList<>();
            DatagramSocket socket = new DatagramSocket(2859);
            byte[] buffer = new byte[2048];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            PrintWriter writer = new PrintWriter("C:\\Users\\owner\\IdeaProjects\\Java-3sem\\src\\pract19_20\\history.txt");
            System.out.println("Server is alive!");
            while (true) {
                socket.receive(packet);
                //System.out.println(packet.getAddress());
                if (!ports.contains(packet.getPort()))
                    ports.add(packet.getPort());
                int t = 0;
                for (int i = 0; i < ports.size(); i++) {
                    if (ports.get(i) == packet.getPort())
                        t++;
                }
                String message = new String(buffer, 0, packet.getLength());
                if (t == 0) {
                    socket.send(new DatagramPacket(message.getBytes(), 0, packet.getLength() + 20, InetAddress.getByName("255.255.255.255"), packet.getPort()));
                }
                writer.write(message + "\n");
                System.out.println(message);
                for (int i : ports) {
                    send(message, i);
                }
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void send(String message, int port) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getByName("255.255.255.255"), port);
        socket.send(packet);
    }
}
