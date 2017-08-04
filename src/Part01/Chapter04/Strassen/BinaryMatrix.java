package Part01.Chapter04.Strassen;

public class BinaryMatrix {

    private static int[][] add(int[][] A,int[][] B,int n)
    {
        int[][] C = new int[n][n];
        for(int i=0;i<n;i++)
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        return C;
    }

    private static int[][] combine(int[][] A11,int[][] A12,int[][] A21,int[][] A22,int n)
    {
        int[][] A = new int[n][n];
        for (int i = 0; i < n/2; i++)
            for (int j = 0; j < n/2; j++) {
                A[i][j] = A11[i][j];
                A[i][j+n/2] = A12[i][j];
                A[i+n/2][j] = A21[i][j];
                A[i+n/2][j+n/2] = A22[i][j];
            }
        return A;
    }

    private static int[][] squareMatrixMultiplyRecursive(PartMatrix partA,PartMatrix partB)
    {
        int n = partA.getWidth();
        int[][] C = new int[n][n];
        if(n == 1)
        {
            C[0][0] = (partA.getMatrix())[partA.getX()][partA.getY()]
                        *(partB.getMatrix())[partB.getX()][partB.getY()];
        }else{
            int[][] C11;
            int[][] C12;
            int[][] C21;
            int[][] C22;
            PartMatrix partA11 = new PartMatrix(partA.getMatrix(),partA.getN(),partA.getX(),partA.getY(),n/2);
            PartMatrix partA12 = new PartMatrix(partA.getMatrix(),partA.getN(),partA.getX(),partA.getY()+partA.getWidth()/2,n/2);
            PartMatrix partA21 = new PartMatrix(partA.getMatrix(),partA.getN(),partA.getX()+partA.getWidth()/2,partA.getY(),n/2);
            PartMatrix partA22 = new PartMatrix(partA.getMatrix(),partA.getN(),partA.getX()+partA.getWidth()/2,partA.getY()+n/2,n/2);
            PartMatrix partB11 = new PartMatrix(partB.getMatrix(),partB.getN(),partB.getX(),partB.getY(),n/2);
            PartMatrix partB12 = new PartMatrix(partB.getMatrix(),partB.getN(),partB.getX(),partB.getY()+n/2,n/2);
            PartMatrix partB21 = new PartMatrix(partB.getMatrix(),partB.getN(),partB.getX()+n/2,partB.getY(),n/2);
            PartMatrix partB22 = new PartMatrix(partB.getMatrix(),partB.getN(),partB.getX()+n/2,partB.getY()+n/2,n/2);
            C11 = add(squareMatrixMultiplyRecursive(partA11,partB11),squareMatrixMultiplyRecursive(partA12,partB21),n/2);
            C12 = add(squareMatrixMultiplyRecursive(partA11,partB12),squareMatrixMultiplyRecursive(partA12,partB22),n/2);
            C21 = add(squareMatrixMultiplyRecursive(partA21,partB11),squareMatrixMultiplyRecursive(partA22,partB21),n/2);
            C22 = add(squareMatrixMultiplyRecursive(partA21,partB12),squareMatrixMultiplyRecursive(partA22,partB22),n/2);
            C = combine(C11,C12,C21,C22,n);
        }
        return C;
    }

    public static void main(String[] args) {
        final int NUM = 128;
        int[][] A = new int[NUM][NUM];
        int[][] B = new int[NUM][NUM];
        int[][] C;
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                A[i][j] = (int)(1+Math.random()*10);
                B[i][j] = (int)(1+Math.random()*10);
            }
        }
        PartMatrix partA = new PartMatrix(A,NUM,0,0,NUM);
        PartMatrix partB = new PartMatrix(B,NUM,0,0,NUM);
        C = squareMatrixMultiplyRecursive(partA,partB);
        System.out.println("A:");
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                if(j == NUM-1)
                    System.out.println(A[i][j]);
                else
                    System.out.print(A[i][j]+" ");
            }
        }
        System.out.println("B:");
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                if(j == NUM-1)
                    System.out.println(B[i][j]);
                else
                    System.out.print(B[i][j]+" ");
            }
        }
        System.out.println("C:");
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                if(j == NUM-1)
                    System.out.println(C[i][j]);
                else
                    System.out.print(C[i][j]+" ");
            }
        }
    }
}
