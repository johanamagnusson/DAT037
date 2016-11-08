
public class MySortedArray<E extends Comparable<? super E>> implements MySet<E> {

	E[] array;

	public MySortedArray(E[] a, E element) {
		array = a;
		System.out.println(member(element));
	}

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