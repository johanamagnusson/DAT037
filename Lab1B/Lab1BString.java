import java.io.*;
import java.util.*;

/**
 * The Lab1B class finds out if an integer is present in a given text file.
 * Program needs two arguments, an integer and a filepath in that order.
 * 
 * @author  Andreas Magnusson, Carl Smedstad
 * @version 1.0
 * @since   2016-11-10
 */
public class Lab1BString {

    /**
     * The main method that reads a file and uses the class MySortedArray to find out
     * if the given integer is present in it.
     * @param args String of two arguments, first one the integer and the last one the filepath.
     * @throws FileNotFoundException if file name does not exists in directory.
     */
    public static void main(String[] args) throws FileNotFoundException {

        String element = args[0];
        String filename = args[1];

        File file = new File(filename);
    	Scanner scan = new Scanner(file).useDelimiter(" ");

	ArrayList<String> input = new ArrayList<String>();

	    while (scan.hasNext()) {
            input.add(scan.next());
	    }

	    MySet sortedStringArray = new MySortedArray<String>
            (input.toArray(new String[input.size()]), element);
	}

}
