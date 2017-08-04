package Part01.Chapter02;

import java.util.Arrays;
import java.util.Date;

/**
 * 实现归并排序
 */
public class MergeSort {
    private static final int INFINITY = Integer.MAX_VALUE;
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
                j++;
            }
        }
    }
    private static void merge1(int[] a,int p,int q,int r)
    {
        int i,j;
        int n1 = q-p+1;
        int n2 = r-q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(i=0;i<n1;i++)
            L[i] = a[i+p];
        for(i=0;i<n2;i++)
            R[i] = a[i+q+1];
        int k = p;
        i=0;
        j=0;
        while(i<n1-1 && j <n2-1)
        {
            if(L[i]<=R[j])
            {
                a[k] = L[i];
                k++;
                i++;
            }else{
                a[k] = R[j];
                k++;
                j++;
            }
        }
        if(i<n1-1){
            for(int t=i;t<n1;t++)
            {
                a[k] = L[t];
                k++;
            }
        }else{
            for(int t=j;t<n2;t++)
            {
                a[k] = R[t];
                k++;
            }
        }
    }

    private static void insertionSort(int[] A,int p,int q)
    {
        for(int j = p+1;j<q;j++){
            int key = A[j];
            //把A[j]插入到A[0..j-1]中
            int i = j-1;
            while(i>=p && A[i]>key) {
                A[i+1] = A[i];
                i--;
            }
            //这里下标是i+1
            A[i+1] = key;
        }
    }

    public static void mergeSort(int[] a,int p,int r)
    {
        if(r-p>10)
        {
            int q = (p+r)/2;
            mergeSort(a,p,q);
            mergeSort(a,q+1,r);
            merge1(a,p,q,r);
        }else{
            insertionSort(a,p,r);
        }
    }

    public static void mergeSort1(int[] a,int p,int r)
    {
        if(p<r)
        {
            int q = (p+r)/2;
            mergeSort(a,p,q);
            mergeSort(a,q+1,r);
            merge1(a,p,q,r);
        }
    }

    public static void main(String[] args)
    {
        final int NUM = 10000000;
        int[] a = new int[NUM+1];
        for(int i=0;i<NUM;i++)
            a[i] = (int)(1+(NUM*10-1)*Math.random());
        //System.out.println(Arrays.toString(a));
        Date d1 = new Date();
        mergeSort(a,0,NUM-1);
        Date d2 = new Date();
        for(int i=0;i<NUM;i++)
            a[i] = (int)(1+(NUM*10-1)*Math.random());
        Date d3 = new Date();
        mergeSort1(a,0,NUM-1);
        Date d4 = new Date();
        System.out.println((d2.getTime()-d1.getTime())/1000.0+ "秒-------"+ (d4.getTime()-d3.getTime())/1000.0+"秒");

        //System.out.println(Arrays.toString(a));
    }
}
