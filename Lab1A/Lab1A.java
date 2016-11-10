import java.io.*;
import java.util.*;

public class Lab1A {
	
	public static void main(String[] args) throws FileNotFoundException {
            System.out.println("Hej");
		int element = Integer.parseInt(args[0]);
		String filename = args[1];
                
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
