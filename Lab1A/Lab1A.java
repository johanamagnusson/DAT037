import java.io.*;
import java.util.*;

public class Lab1A {
	
	public static void main(String[] args) throws FileNotFoundException {

		assert args.length == 2;

		if (args.length != 2) {
			System.out.println("Not enough argumentsPlease run as \"java Lab1A <filename> <element>\". Exits...");
			System.exit(0);
		}

		String filename = args[0];
		int element = Integer.parseInt(args[1]);

		File file = new File(filename);
		Scanner scan = new Scanner(file);

		ArrayList<Integer> input = new ArrayList<Integer>();

		while (scan.hasNextInt()) {
			input.add(scan.nextInt());
		}

		int[] intArray = new int[input.size()];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = input.get(i).intValue();
		}

		MyIntSet sortedIntArray = new MySortedIntArray(intArray, element);
	}

}