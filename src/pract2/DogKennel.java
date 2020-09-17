package pract2;

import java.util.Scanner;

public class DogKennel {
    public void addDog(){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Dog [] ken = new Dog[N];
        for(int i=0; i<N; i++){
            String n = scan.next();
            int a = (int)(Math.random()*15)+1;
            ken[i] = new Dog(n, a);
            System.out.print(ken[i].getName()+" "+ken[i].getAge());
        }
    }

}
