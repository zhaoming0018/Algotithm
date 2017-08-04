package Part01.Chapter04.Strassen;

public class Simple {
    public static void main(String[] args) {
        final int NUM = 4;
        int[][] A = new int[NUM][NUM];
        int[][] B = new int[NUM][NUM];
        int[][] C = new int[NUM][NUM];
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                A[i][j] = (int)(1+Math.random()*100);
                B[i][j] = (int)(1+Math.random()*100);
            }
        }
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                C[i][j] = 0;
                for (int k = 0; k < NUM; k++)
                    C[i][j] += A[i][k] * B[k][j];
                if(j == NUM-1)
                    System.out.println(C[i][j]);
                else
                    System.out.print(C[i][j]+" ");
            }
        }
    }
}
