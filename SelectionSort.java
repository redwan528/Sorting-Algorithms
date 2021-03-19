
public class SelectionSort extends TestTimes implements SortInterface {

	@Override
	public void sort(Integer[] arrayToSort) {
		int n = arrayToSort.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (arrayToSort[minIndex] > arrayToSort[j]) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				int temp = arrayToSort[i];
				arrayToSort[i] = arrayToSort[minIndex];
				arrayToSort[minIndex] = temp;
			}
		}
	}
}
