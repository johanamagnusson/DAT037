/**
* The class MySortedIntArray implements binary search to conclude if an input integer
* is present in a given sorted array of integers. 
*
* @author  Andreas Magnusson, Carl Smedstad
* @version 1.0
* @since   2016-11-10
*/

public class MySortedIntArray implements MyIntSet {

    int[] array;

    /**
     * Constructor for MySortedIntArray.
     * @param array array of primitive integers
     * @param element element of datatyp int
     */  
    public MySortedIntArray(int[] a, int element) {
        array = a;
	System.out.println(member(element));
    }

    /**
     * Returns true if input element exists in the array called array.
     * @param element element of datatype int
     * @return boolean
     */
    @Override
    public boolean member(int element) {

        int start = 0;
	int end = array.length - 1;

	while (start <= end) {

	    int mid = (start + end) / 2;

	    if (element < array[mid]) {
	        end = mid - 1;
	    }
	    else if (element > array[mid]) {
                start = mid + 1;
	    } else {
	        return true;
	    }
        }
        return false;
    }
}
