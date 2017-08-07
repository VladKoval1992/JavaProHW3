import java.io.IOException;

public class MyClass{
    public static void main(String[] args) {
        final String path = "С:\\text.txt";
        Parser jp = new Parser(path);
        try {
            jp.parser();
        } catch (IOException exc) {
            exc.getMessage();
        }
    }
}