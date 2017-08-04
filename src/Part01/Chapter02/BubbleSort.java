package Part01.Chapter02;

import java.util.Scanner;

public class BubbleSort {
    private static void bubbleSort(int[] a,int n)
    {
        for(int i=0;i<n-1;i++)
            for(int j=n-1;j>i;j--)
            {
                int c;
                if(a[j]<a[j-1])
                {
                    c = a[j];
                    a[j] = a[j-1];
                    a[j-1] = c;
                }
            }
    }
    public static void main(String[] args)
    {
        int[] a = new int[100];
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0;i<n;i++)
            a[i] = (int)(1+9999*Math.random());
        bubbleSort(a,n);
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}
