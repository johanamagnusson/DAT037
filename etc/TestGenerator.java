import java.io.*;
import java.util.*;

public class TestGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        int amount = Integer.parseInt(args[0]);
        String[] strArr = new String[amount*2-1];
        for (int i = 0; i < amount; i++) {
            System.out.println(i);
            strArr[i*2] = Integer.toString(i);
            strArr[i*2+1] = " ";
        }
        String str = Arrays.toString(strArr);
        System.out.println(str);
        //PrintWriter writer = new PrintWriter("test"+amount+".txt");
        //writer.println(str);
        //writer.close();
    }
}
