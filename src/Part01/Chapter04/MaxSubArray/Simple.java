package Part01.Chapter04.MaxSubArray;

public class Simple {
    public static void main(String[] args)
    {
        int[] Prices = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
        int[] changes = new int[Prices.length-1];
        for(int i=0;i<Prices.length-1;i++)
            changes[i] = Prices[i+1]-Prices[i];
        int[] sum = new int[changes.length];
        sum[0] = changes[0];
        for(int i=1;i<sum.length;i++)
            sum[i] = sum[i-1]+changes[i];
        int max = 0;
        for(int i=0;i<sum.length-1;i++)
            for(int j=i+1;j<sum.length;j++)
            {
                if(sum[j]-sum[i]>max)
                    max = sum[j]-sum[i];
            }
        System.out.println(max);
    }
}
