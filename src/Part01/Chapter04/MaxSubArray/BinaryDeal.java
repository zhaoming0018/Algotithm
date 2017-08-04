package Part01.Chapter04.MaxSubArray;

public class BinaryDeal {
    private static int findMaxCrossingSubArray(int[] A,int low,int mid,int high)
    {
        int max_left = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid;i>=low;i--)
        {
            sum += A[i];
            if(sum > max_left)
                max_left = sum;
        }
        sum = 0;
        int max_right = Integer.MIN_VALUE;
        for(int i=mid+1;i<=high;i++)
        {
            sum += A[i];
            if(sum>max_right)
                max_right = sum;
        }
        return max_left+max_right;
    }

    private static int findMaximumSubarray(int[] A,int low,int high)
    {
        int left_sum,right_sum,cross_sum;
        if (high == low)
            return A[low];
        else {
            int mid = (low+high)/2;
            left_sum = findMaximumSubarray(A,low,mid);
            right_sum = findMaximumSubarray(A,mid+1,high);
            cross_sum = findMaxCrossingSubArray(A,low,mid,high);
            //输出当前阶段结果
            System.out.println("A["+low+"~"+high+"]  mid is "+mid);
            System.out.print("Array Element is:");
            for(int i=low;i<=high;i++)
                System.out.print(A[i]+" ");
            System.out.println();
            System.out.println("Current Result: left-max="+left_sum+" right-max="+right_sum
                +" cross-max="+cross_sum);

            if(left_sum>=right_sum && left_sum>=cross_sum)
                return left_sum;
            else if(right_sum>=left_sum && right_sum>=cross_sum)
                return right_sum;
            else
                return cross_sum;
        }
    }

    public static void main(String[] args)
    {
        int[] Prices = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
        int[] changes = new int[Prices.length-1];
        for(int i=0;i<Prices.length-1;i++)
            changes[i] = Prices[i+1]-Prices[i];
        int max = findMaximumSubarray(changes,0,changes.length-1);
        System.out.println(max);
    }
}
