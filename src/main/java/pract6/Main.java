package pract6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        int i = 0, j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                //a[i][j] = (int) (Math.random() * 200 - 100) + 1;
                a[i][j] = scan.nextInt();
                //System.out.print(a[i][j] + "  ");
            }
            //System.out.println();
        }
        System.out.println();
        int s1 = 0, s2 = 0, s3 = 0, s4 = 0, s = a[0][0];
        i = 0;
        j = 0;
        while (i != n - 1 || j != n - 1) {
            int max;
            if (i == n - 1 || j == n - 1) {
                if (i == n - 1) {
                    s += a[i][j + 1];
                    j++;
                } else if (j == n - 1) {
                    s += a[i + 1][j];
                    i++;
                }
            } else {
                if (j != n - 2 && i != n - 2) {
                    s1 = a[i][j + 1] + a[i][j + 2];
                    s2 = a[i][j + 1] + a[i + 1][j + 1];
                    s3 = a[i + 1][j] + a[i + 2][j];
                    s4 = a[i + 1][j] + a[i + 1][j + 1];
                } else if (i == n - 2 && j != n - 2) {
                    s1 = a[i][j + 1] + a[i][j + 2];
                    s2 = a[i][j + 1] + a[i + 1][j + 1];
                    s4 = a[i + 1][j] + a[i + 1][j + 1];
                    s3 = s4;
                } else if (i != n - 2 && j == n - 2) {
                    s2 = a[i][j + 1] + a[i + 1][j + 1];
                    s1 = s2;
                    s3 = a[i + 1][j] + a[i + 2][j];
                    s4 = a[i + 1][j] + a[i + 1][j + 1];
                } else if (i == n - 2 && j == n - 2) {
                    s2 = a[i][j + 1] + a[i + 1][j + 1];
                    s1 = s2;
                    s4 = a[i + 1][j] + a[i + 1][j + 1];
                    s3 = s4;
                }
                max = maximum(s1, s2, s3, s4);
                if (s2 == s4) {
                    if (s1 > s3) {
                        s += a[i][j + 1];
                        j++;
                    } else if (s1 < s3) {
                        s += a[i + 1][j];
                        i++;
                    } else {
                        if (a[i][j + 1] > a[i + 1][j])
                            s += a[i][j + 1];
                        else
                            s += a[i + 1][j];
                        i++;
                        j++;
                    }
                } else if (s1 == s3) {
                    if (s2 > s4) {
                        s += a[i][j + 1];
                        j++;
                    } else if (s2 < s4) {
                        s += a[i + 1][j];
                        i++;
                    }
                } else {
                    if (max == s1 || max == s2) {
                        s += a[i][j + 1];
                        j++;
                    } else if (max == s3 || max == s4) {
                        s += a[i + 1][j];
                        i++;
                    }
                }
            }
            System.out.println(s + " " + a[i][j] + " " + i + " " + j);
        }
        System.out.println(s);
    }

    public static int maximum(int s1, int s2, int s3, int s4) {
        int max = -101;
        if (max < s1)
            max = s1;
        if (max < s2)
            max = s2;
        if (max < s3)
            max = s3;
        if (max < s4)
            max = s4;
        return max;
    }
}
