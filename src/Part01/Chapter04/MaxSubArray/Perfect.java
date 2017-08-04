package Part01.Chapter04.MaxSubArray;

public class Perfect {
    public static void main(String[] args) {
        int[] Prices = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
        int[] changes = new int[Prices.length-1];
        for(int i=0;i<Prices.length-1;i++)
            changes[i] = Prices[i+1]-Prices[i];
        int sum = 0,max=Integer.MIN_VALUE;
        for(int i=0;i<changes.length;i++)
        {
            sum += changes[i];
            if(sum>max) max = sum;
            if(sum < 0)
                sum = 0;
        }
        System.out.println(max);
    }
}
