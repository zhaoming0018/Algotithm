package Part01.Chapter04.Strassen;

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
}
