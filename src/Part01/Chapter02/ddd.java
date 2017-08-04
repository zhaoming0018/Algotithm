package Part01.Chapter02;

public class ddd {
    private static ddd ourInstance = new ddd();

    public static ddd getInstance() {
        return ourInstance;
    }

    private ddd() {
    }
}
