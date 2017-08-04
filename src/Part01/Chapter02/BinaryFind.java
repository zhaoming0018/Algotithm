package Part01.Chapter02;

public class BinaryFind {
    /**
     * 在递增数组A的一个范围中寻找值k
     * @param A 数组A
     * @param p 开始位置a[p]
     * @param r 结束位置a[r]
     * @param k 寻找值k
     * @return 返回k的位置，若没有，返回-1
     */
    public static int binaryFind(int[] A,int p,int r,int k)
    {
        int i=p,j=r,mid;
        while(i<=j)
        {
            mid = (i+j)/2;
            if(k == A[mid])     return mid;
            else if(k<A[mid])   j = mid - 1;
            else                i = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] a = {2,4,6,7,9,12,34,55};
        System.out.println(binaryFind(a,0,7,12));
    }
}
