package pract3;

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double r = scan.nextDouble();
        Circle c1 = new Circle(r);
        System.out.println(c1.getRadius());
        System.out.println(c1.getSquare());
        System.out.println(c1.getPerimeter());
    }
}
