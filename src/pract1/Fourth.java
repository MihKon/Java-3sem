package pract1;

import java.util.Arrays;
import java.util.Random;

public class Fourth {
    public static void main(String[] arg){
        int[] a = new int[10];
        int i, j;
        for (i=0; i<10; i++){
            a[i] =  0+(int) (Math.random()*80);
            System.out.print(a[i] + " ");
        }
        Arrays.sort(a);
        System.out.println();
        for (j=0; j<10; j++){
            System.out.print(a[j]+" ");
        }
        System.out.println();
        int[] b = new int[10];
        for (i=0; i<10; i++)
        {
            Random rand = new Random();
            b[i] = rand.nextInt(100);
            System.out.print(b[i] + " ");
        }
        Arrays.sort(b);
        System.out.println();
        for (j=0; j<10; j++){
            System.out.print(b[j]+" ");
        }
    }
}
