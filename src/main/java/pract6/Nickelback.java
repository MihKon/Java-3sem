package pract6;

import java.util.Scanner;

public class Nickelback {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        int i = 0, j = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = (int) (Math.random() * 200 - 100) + 1;
                //a[i][j] = scan.nextInt();
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    a[i][j] += Math.max(a[i - 1][j], a[i][j - 1]);
                } else if (i > 0) {
                    a[i][j] += a[i - 1][j];
                } else if (j > 0) {
                    a[i][j] += a[i][j - 1];
                }
            }
        }

        System.out.println(a[n - 1][n - 1]);
    }
}
