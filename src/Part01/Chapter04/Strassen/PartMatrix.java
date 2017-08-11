package Part01.Chapter04.Strassen;

import java.util.Arrays;

public class PartMatrix{
    private int[][] matrix;
    private int n;
    private int x;
    private int y;
    private int width;

    public PartMatrix(int[][] matrix, int n, int x, int y, int width) {
        this.matrix = matrix;
        this.n = n;
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public int[][] toArray(){
        int[][] arr = new int[width][width];
        for (int i = 0; i < width; i++) {
            System.arraycopy(matrix[i + x], y, arr[i], 0, width);
        }
        return arr;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if(j == width - 1){
                    sb.append(matrix[i][j]);
                    if(i!=width-1)  sb.append("; ");
                }else{
                    sb.append(matrix[i][j]);
                    sb.append(" , ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
