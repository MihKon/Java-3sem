package pract3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double l;
        float w;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter head");

        l = scan.nextDouble();
        w = scan.nextFloat();

        Head head = new Head(l, w);

        System.out.println("Enter right hand");

        l = scan.nextDouble();
        w = scan.nextFloat();

        Hand rhand = new Hand(l, w);

        System.out.println("Enter left hand");

        l = scan.nextDouble();
        w = scan.nextFloat();

        Hand lhand = new Hand(l, w);

        System.out.println("Enter right leg");

        l = scan.nextDouble();
        w = scan.nextFloat();

        Leg rleg = new Leg(l, w);

        System.out.println("Enter left leg");

        l = scan.nextDouble();
        w = scan.nextFloat();

        Leg lleg = new Leg(l, w);

        Human man = new Human(head, rhand, lhand, rleg, lleg);

        System.out.println("Head:");
        System.out.println("Length: "+man.getHead().getLength()+" Weight:"+man.getHead().getWeight());
        System.out.println("Right Hand:");
        System.out.println("Length: "+man.getRhand().getLength()+" Weight:"+man.getRhand().getWeight());
        System.out.println("Left Hand:");
        System.out.println("Length: "+man.getLhand().getLength()+" Weight:"+man.getLhand().getWeight());
        System.out.println("Right Leg:");
        System.out.println("Length: "+man.getRleg().getLength()+" Weight:"+man.getRleg().getWeight());
        System.out.println("Left Leg:");
        System.out.println("Length: "+man.getLleg().getLength()+" Weight:"+man.getLleg().getWeight());
    }
}
