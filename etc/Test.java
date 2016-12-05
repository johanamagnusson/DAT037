import java.util.regex.*;

public class Test {
    public static void main(String args[]) {
        boolean b = Pattern.matches("a*b", "aaaaaab");
        System.out.println(b);
    }
}
