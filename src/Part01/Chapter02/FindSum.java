package Part01.Chapter02;

import java.util.Date;
import java.util.Scanner;

public class FindSum {
    public static void main(String[] args)
    {
        int n,x,i;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] a = new int[10000000];
        for(i=0;i<n;i++)
            a[i] = (int)(1+Math.random()*99999999);
        x = (int)(2+Math.random()*199999998);
        Date start = new Date();
        MergeSort.mergeSort(a,0,n-1);
        for(i=0;i<n-1;i++)
        {
            int pos;
            if((pos = BinaryFind.binaryFind(a,i+1,n-1,x-a[i])) != -1)
            {
                System.out.println("sum : "+ x +"\n a["+i+"] : "+a[i] + " a["+pos+"] : "+ a[pos]);
                break;
            }
        }
        if(i == n-1)
            System.out.println("No solution!");
        Date end = new Date();
        double interval = (end.getTime()-start.getTime())/1000.0;
        System.out.println("执行时间： "+interval+"秒");
    }
}
