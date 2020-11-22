package sidequests;

import java.util.Scanner;

public class Nickelback {
    int sum;
    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int i, j, k, p = 1;
        System.out.println(p);
    }*/

    public Nickelback(int sum) {
        this.sum = sum;
    }

    public int F(){
        int p = 0;
        for (int i=1; i<=this.sum/5; i++){
            for (int j=1; j<=this.sum/3; j++){
                for (int k=0; k<=this.sum; k++){
                    if ((5*i + 3*j + k) == this.sum)
                        p++;
                }
            }
        }
        return p;
    }
    public int F3(){
        int p=0;
        for (int i=1; i<this.sum; i++){
            for (int j=0; j<this.sum; j++){
                if ((3*i + j) == this.sum)
                    p++;
            }
        }
        return p;
    }
    public int F5(){
        int p=0;
        for (int i=1; i<this.sum; i++){
            for (int j=0; j<this.sum; j++){
                if ((5*i + j) == this.sum)
                    p++;
            }
        }
        return p;
    }
}
