import java.io.*;
import java.util.*;

public class Lab1B {
	
	public static void main(String[] args) throws FileNotFoundException {

		int element = Integer.parseInt(args[0]);
		String filename = args[1];

		File file = new File(filename);
		Scanner scan = new Scanner(file);

		ArrayList<Integer> input = new ArrayList<Integer>();

		while (scan.hasNextInt()) {
			input.add(scan.nextInt());
		}

		MySet sortedIntArray = new MySortedArray<Integer>(input.toArray(new Integer[input.size()]), element);
	}

}