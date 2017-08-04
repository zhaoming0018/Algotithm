package Part01.Chapter02;

/**
 * 二进制加法
 */
public class ByteAdd {
    private static final int NUM = 7;
    private static int[] stringToArr(String bytes) {
        int[] arr = new int[NUM];
        for(int i=0;i<NUM;i++){
            arr[i] = Integer.parseInt(""+bytes.charAt(NUM-1-i));
        }
        return arr;
    }

    private static String byteAdd(String bytes1, String bytes2)
    {
        //将字符串转换为01数组
        int[] arr1 = new int[7];
        int[] arr2 = new int[7];
        int[] arr3 = new int[8];
        arr1 = stringToArr(bytes1);
        arr2 = stringToArr(bytes2);
        int g = 0,s=0;
        //循环计算
        for(int i=0;i<NUM;i++)
        {
            s = arr1[i]+arr2[i]+g;
            arr3[i] = s%2;
            g=s/2;
        }
        arr3[NUM] = g;
        StringBuilder sb = new StringBuilder("");
        for(int i=NUM;i>=0;i--)
        {
            sb.append(arr3[i]);
        }
        return sb.toString();
    }



    public static void main(String[] args)
    {
        String bytes1 = "1001001";
        String bytes2 = "1101010";
        String bytes3 = byteAdd(bytes1,bytes2);
        System.out.println(" "+bytes1);
        System.out.println(" "+bytes2);
        System.out.println(bytes3);
    }
}
