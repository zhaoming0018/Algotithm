package Part01.Chapter02;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * 插入排序
 */
public class InsertionSort {
    private static short UP = 0;
    private static short DOWN = 1;
    private static void print(Object a){
        System.out.println(a);
    }

    private static int binaryPlaceFind(int[] A,int p,int q,int value)
    {
        int i=p,j=q,mid;
        while(i<j)
        {
            mid = (i+j)/2;
            if(value <= A[mid]) j =mid;
            else i = mid + 1;
        }
        if(A[i]<value)  return i+1;
                else    return i;
    }

    private static void insertionSortUP1(int[] A,int n)
    {
        for(int j = 1;j<n;j++){
            int key = A[j];
            //把A[j]插入到A[0..j-1]中
//            int i = j-1;
//            while(i>=0 && A[i]>key) {
//                A[i + 1] = A[i];
//                i--;
//            }
            int place = binaryPlaceFind(A,0,j-1,key);
            for(int i=j-1;i>=place;i--)
                A[i+1] = A[i];
            A[place] = key;
        }
    }
    private static void insertionSortUP(int[] A,int n)
    {
        for(int j = 1;j<n;j++){
            int key = A[j];
            //把A[j]插入到A[0..j-1]中
            int i = j-1;
            while(i>=0 && A[i]>key) {
                A[i + 1] = A[i];
                i--;
            }
            //这里下标是i+1
            A[i+1] = key;
        }
    }
    private static void insertionSortDown(int[] A,int n)
    {
        for(int j = 1;j<n;j++){
            int key = A[j];
            //把A[j]插入到A[0..j-1]中
            int i = j-1;
            while(i>=0 && A[i]<key) {
                A[i + 1] = A[i];
                i--;
            }
            //这里下标是i+1
            A[i+1] = key;
        }
    }
    public static void insertionSort(int[] A,int n,short flag)
    {
        if(flag == UP)  insertionSortUP(A,n);
                else    insertionSortDown(A,n);
    }

    public static void main(String[] args)
    {
        int[] a = new int[1000000];
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0 ;i < n;i++)
            a[i] = (int)(1+Math.random()*9999);
        Date d1 = new Date();
        insertionSort(a,n,UP);
        Date d2 = new Date();
        for(int i = 0 ;i < n;i++)
            a[i] = (int)(1+Math.random()*9999);
        Date d3 = new Date();
        insertionSort(a,n,DOWN);
        Date d4 = new Date();
        System.out.println((d2.getTime()-d1.getTime())/1000.0+ "秒-------"+ (d4.getTime()-d3.getTime())/1000.0+"秒");
        //for(int i=0;i<n;i++)
        //    System.out.print(a[i]+ " ");
        //System.out.println();
    }
}
