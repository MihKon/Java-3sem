package pract5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*System.out.println("Enter point and speed");
        System.out.print("x = ");
        int x = scan.nextInt();
        System.out.print("y = ");
        int y = scan.nextInt();
        System.out.print("ySpeed = ");
        int ySpeed = scan.nextInt();
        System.out.print("xSpeed = ");
        int xSpeed = scan.nextInt();
        MovablePoint point = new MovablePoint(x, y, ySpeed, xSpeed);
        System.out.println(point);
        point.moveUp();
        point.moveRight();
        System.out.println(point);

        System.out.println();
        System.out.println("Enter center of circle, speed of center and radius of circle");
        System.out.print("x = ");
        x = scan.nextInt();
        System.out.print("y = ");
        y = scan.nextInt();
        System.out.print("ySpeed = ");
        ySpeed = scan.nextInt();
        System.out.print("xSpeed = ");
        xSpeed = scan.nextInt();
        System.out.print("radius = ");
        int r = scan.nextInt();
        MovableCircle circle = new MovableCircle(x, y, ySpeed, xSpeed, r);
        System.out.println(circle);
        circle.moveDown();
        circle.moveLeft();
        System.out.println(circle);*/
        MovableRectangle r = new MovableRectangle(0, 1, 1, -1);
        System.out.println(r);
        r.setWidth(7);
        r.setLength(5);
        System.out.println(r);
    }
}
