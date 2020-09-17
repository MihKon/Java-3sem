package pract1;

import java.util.Scanner;

public class Fifth {
    public static void main(String[] arg){
        int fact;
        Scanner scan = new Scanner(System.in);
        fact = scan.nextInt();
        System.out.print(factor(fact));
    }
    public static int factor(int f){
        int res=1;
        while(f>0){
            res *=f;
            f--;
        }
        return res;
    }
}
