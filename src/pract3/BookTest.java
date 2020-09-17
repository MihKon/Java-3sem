package pract3;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String author = scan.nextLine();
        String name = scan.nextLine();
        String date = scan.nextLine();
        Book b1 = new Book(author, name, date);
        b1.getAuthor();
        b1.getName();
        b1.getDate();
    }
}
