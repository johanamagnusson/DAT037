/**
* The class MySortedArray implements binary search to conclude if an input value
* is present in a given sorted array. 
*
* @author  Andreas Magnusson, Carl Smedstad
* @version 1.0
* @since   2016-11-10
*/

public class MySortedArray<E extends Comparable<? super E>> implements MySet<E> {

    E[] array;

    /**
     * Constructor for MySortedArray.
     * @param a array of datatype E
     * @param element element of datatype E
     */  
    public MySortedArray(E[] a, E element) {
        array = a;
	System.out.println(member(element));
    }

    /**
     * Returns true if input element exists in the array called array.
     * @param element element of datatype E
     * @return boolean
     */
    @Override
    public boolean member(E element) {

        int start = 0;
	int end = array.length - 1;

	while (start <= end) {

	    int mid = (start + end) / 2;

	    if (element.compareTo(array[mid]) < 0) {
	        end = mid - 1;
	    }
	    else if (element.compareTo(array[mid]) > 0) {
	        start = mid + 1;
	    } else {
	        return true;
	    }
	}
    return false;
    }
}
