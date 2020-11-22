package pract1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // п.1
        int[] m = new int[5];
        int i, sum=0;
        for(i=0; i<5; i++){
            m[i] = scan.nextInt();
            sum+=m[i];
        }
        System.out.println("summa = " + sum);
        sum=0;
        i=0;
        while (i<5){
            sum+=m[i];
            i++;
        }
        System.out.println(sum);
        sum=0;
        i=0;
        do {
            sum+=m[i];
            i++;
        }while(i<5);
        System.out.println(sum);
        scan.close();
    }
}
