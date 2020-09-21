package pract6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        int i=0, j=0;
        for (i=0; i<n; i++){
            for(j=0; j<n; j++){
                a[i][j] = (int) (Math.random()*40-20) + 1;
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
        
    }
}
