package Part01.Chapter04.Strassen;

import java.util.Arrays;

public class Strassen {
    private static int[][] add(int[][] A,int[][] B,int n)
    {
        int[][] C = new int[n][n];
        for(int i=0;i<n;i++)
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        return C;
    }

    private static int[][] minus(int[][] A,int[][] B,int n)
    {
        int[][] C = new int[n][n];
        for(int i=0;i<n;i++)
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        return C;
    }

    private static int[][] add(PartMatrix A,PartMatrix B)
    {
        int n = A.getWidth();
        int[][] arr = new int[n][n];
        for (int i = 0; i < A.getWidth(); i++)
            for (int j = 0; j < A.getWidth(); j++)
                arr[i][j] = (A.getMatrix())[i+A.getX()][j+A.getY()] + (B.getMatrix())[i+B.getX()][j+B.getY()];
        return arr;
    }

    private static int[][] minus(PartMatrix A,PartMatrix B)
    {
        int n = A.getWidth();
        int[][] arr = new int[n][n];

        for (int i = 0; i < A.getWidth(); i++)
            for (int j = 0; j < A.getWidth(); j++)
                arr[i][j] = (A.getMatrix())[i+A.getX()][j+A.getY()] - (B.getMatrix())[i+B.getX()][j+B.getY()];
        return arr;
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
            PartMatrix partA11 = new PartMatrix(partA.getMatrix(),partA.getN(),partA.getX(),partA.getY(),n/2);
            PartMatrix partA12 = new PartMatrix(partA.getMatrix(),partA.getN(),partA.getX(),partA.getY()+partA.getWidth()/2,n/2);
            PartMatrix partA21 = new PartMatrix(partA.getMatrix(),partA.getN(),partA.getX()+partA.getWidth()/2,partA.getY(),n/2);
            PartMatrix partA22 = new PartMatrix(partA.getMatrix(),partA.getN(),partA.getX()+partA.getWidth()/2,partA.getY()+n/2,n/2);
            PartMatrix partB11 = new PartMatrix(partB.getMatrix(),partB.getN(),partB.getX(),partB.getY(),n/2);
            PartMatrix partB12 = new PartMatrix(partB.getMatrix(),partB.getN(),partB.getX(),partB.getY()+n/2,n/2);
            PartMatrix partB21 = new PartMatrix(partB.getMatrix(),partB.getN(),partB.getX()+n/2,partB.getY(),n/2);
            PartMatrix partB22 = new PartMatrix(partB.getMatrix(),partB.getN(),partB.getX()+n/2,partB.getY()+n/2,n/2);
            PartMatrix S1 = new PartMatrix(minus(partB12,partB22),n/2,0,0,n/2);
            PartMatrix S2 = new PartMatrix(add(partA11,partA12),n/2,0,0,n/2);
            PartMatrix S3 = new PartMatrix(add(partA21,partA22),n/2,0,0,n/2);
            PartMatrix S4 = new PartMatrix(minus(partB21,partB11),n/2,0,0,n/2);
            PartMatrix S5 = new PartMatrix(add(partA11,partA22),n/2,0,0,n/2);
            PartMatrix S6 = new PartMatrix(add(partB11,partB22),n/2,0,0,n/2);
            PartMatrix S7 = new PartMatrix(minus(partA12,partA22),n/2,0,0,n/2);
            PartMatrix S8 = new PartMatrix(add(partB21,partB22),n/2,0,0,n/2);
            PartMatrix S9 = new PartMatrix(minus(partA11,partA21),n/2,0,0,n/2);
            PartMatrix S10 = new PartMatrix(add(partB11,partB12),n/2,0,0,n/2);
            int[][] P1 = squareMatrixMultiplyRecursive(partA11,S1);
            int[][] P2 = squareMatrixMultiplyRecursive(S2,partB22);
            int[][] P3 = squareMatrixMultiplyRecursive(S3,partB11);
            int[][] P4 = squareMatrixMultiplyRecursive(partA22,S4);
            int[][] P5 = squareMatrixMultiplyRecursive(S5,S6);
            int[][] P6 = squareMatrixMultiplyRecursive(S7,S8);
            int[][] P7 = squareMatrixMultiplyRecursive(S9,S10);
            int[][] C11 = add(minus(add(P5,P4,n/2),P2,n/2),P6,n/2);
            int[][] C12 = add(P1,P2,n/2);
            int[][] C21 = add(P3,P4,n/2);
            int[][] C22 = minus(minus(add(P5,P1,n/2),P3,n/2),P7,n/2);
            C = combine(C11,C12,C21,C22,n);
        }
        return C;
    }

    private static void Print(int[][] arr,int n)
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j == n-1)
                    System.out.println(arr[i][j]);
                else
                    System.out.print(arr[i][j]+" ");
            }
        }
    }

    public static void main(String[] args) {
        final int NUM = 2;

        int[][] A = new int[NUM][NUM];
        int[][] B = new int[NUM][NUM];

        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                A[i][j] = (int)(1+Math.random()*10);
                B[i][j] = (int)(1+Math.random()*10);
            }
        }
        System.out.println(Arrays.toString(A));
        PartMatrix partA = new PartMatrix(A,NUM,0,0,NUM);
        PartMatrix partB = new PartMatrix(B,NUM,0,0,NUM);

        int[][] C = squareMatrixMultiplyRecursive(partA,partB);
        System.out.println("A:");
        Print(A,NUM);
        System.out.println("B:");
        Print(B,NUM);
        System.out.println("C:");
        Print(C,NUM);
    }
}
