package sidequests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        //Nickelback n = new Nickelback(sum);
        //int p = 1+n.F3()+n.F5();
        int i, j, k, p = 0;
        for (i=0; i<=sum/5; i++){
            for (j=0; j<=sum/3; j++){
                for (k=0; k<=sum; k++){
                    if ((5*i + 3*j + k) == sum)
                        p++;
                }
            }
        }
        System.out.println(p);
    }
}
