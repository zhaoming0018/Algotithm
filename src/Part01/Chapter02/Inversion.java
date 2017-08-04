package Part01.Chapter02;

import java.util.Arrays;

public class Inversion {
    private static final int INFINITY = Integer.MAX_VALUE;
    private static int sum = 0;
    private static void merge(int[] a,int p,int q,int r)
    {
        int i,j;
        int n1 = q-p+1;
        int n2 = r-q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for(i=0;i<n1;i++)
            L[i] = a[i+p];
        for(i=0;i<n2;i++)
            R[i] = a[i+q+1];
        L[n1] = INFINITY;
        R[n2] = INFINITY;
        i = 0;
        j = 0;
        for(int k = p;k<=r;k++)
        {
            if(L[i]<=R[j])
            {
                a[k] = L[i];
                i++;
            }else{
                a[k] = R[j];
                sum += n1 - i;
                j++;
            }
        }
    }
    public static void mergeSort(int[] a,int p,int r)
    {
        if(p<r)
        {
            int q = (p+r)/2;
            mergeSort(a,p,q);
            mergeSort(a,q+1,r);
            merge(a,p,q,r);
        }
    }
    public static void main(String[] args)
    {
        final int NUM = 100;
        int[] a = new int[NUM];
        for(int i=0;i<NUM;i++)
            a[i] = (int)(1+Math.random()*999);
        System.out.println(Arrays.toString(a));
        mergeSort(a,0,NUM-1);
        System.out.println(sum);
    }
}
