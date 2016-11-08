
public class MySortedIntArray implements MyIntSet {

	int[] array;

	public MySortedIntArray(int[] a, int element) {
		array = a;
		System.out.println(member(element));
	}

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