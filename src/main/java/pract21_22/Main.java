package pract21_22;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Выбирете способ, который хотите использовать:\n" +
                "1 - Сервер\n" +
                "2 - Файл");
        int n = scan.nextInt();
        switch (n) {
            case 1: {
                WithServer server = new WithServer();
                break;
            }
            case 2: {
                MainWithFile file = new MainWithFile();
                break;
            }
        }
    }
}
