import java.util.ArrayList;

import java.util.Random;

public class Driver implements DriverInterface {
	public static enum sorting {
		BUBBLESORT, INSERTIONSORT, SELECTIONSORT
	}

	public static void main(String[] args) {
		Driver d = new Driver();
		
			for(DriverInterface.SortType sortType: DriverInterface.SortType.values()) { //pick one for every item in sortType
				for(DriverInterface.ArrayType arrayType:DriverInterface.ArrayType.values()) {
					for(int arraySize=1000; arraySize<=10000; arraySize+=9000) {
						TestTimes testTimes = d.runSort(sortType, arrayType,arraySize,10);
						
						long[] times=testTimes.getTestTimes();
						System.out.println(sortType + " " +arrayType+ " "+arraySize);
						System.out.println("--------");
						for(int j =0; j<times.length; j++) {
							System.out.print(times[j]+"   ");
							
						}
						System.out.println(testTimes.getAverageTestTime());
						System.out.println();
						System.out.println();
					}
				}
			}
		/*
		 * switch (sort){ case BUBBLESORT:
		 * d.runSort(DriverInterface.SortType.BubbleSort,
		 * DriverInterface.ArrayType.Equal, 1000, 10); break; switch (sort)
		 * 
		 * 
		 * }
		 * 
		 */


	}

	@Override
	public Integer[] createArray(DriverInterface.ArrayType arrayType, int arraySize) {

		Integer[] array = new Integer[arraySize];

		switch (arrayType) {
		case Equal:
			Integer myInt = new Integer(arraySize); // created an array w/ 7 elements
			for (int i = 0; i < array.length; i++) {
				array[i] = myInt;
			}
			break;

		case Increasing:
			Integer incrArray = new Integer(arraySize);

			for (int i = 0; i < array.length; i++) {
				array[i] = incrArray++;
			}
			break;

		case Decreasing:
			Integer DecArray = new Integer(7);
			for (int i = 0; i < array.length; i++) {
				array[i] = DecArray--;
			}

			break;

		case Random:
			Random rand = new Random();
			Integer randArray = new Integer(7);
			for (int i = 0; i < array.length; i++) {
				array[i] = rand.nextInt(); // sorts random ints in array

			}
			break;

		case IncreasingAndRandom:
			int[] n = new int[100000];
			// ArrayList<Integer> list = new ArrayList<Integer>(n);
			// Random r = new Random();
			Integer rArray = new Integer(100000);
			for (int i = 0; i < array.length; i++) {
				array[i] = (int) (Math.random() * 100000);

				// list.add(random.nextInt(1000000));
				array[i] = rArray++;
				// array[i]=r.nextInt(); //sorts random ints in array

			}
			break;
		}

		return array;
	}

	@Override
	public TestTimes runSort(DriverInterface.SortType sortType, DriverInterface.ArrayType arrayType, int arraySize,
			int numberOfTimes) {

		Integer[] array = new Integer[arraySize];

		SortInterface sort = null;
		switch (sortType) {

		case BubbleSort:

			sort = new BubbleSort();

			break;
		case SelectionSort:

			sort = new SelectionSort();

			break;
		case InsertionSort:

			sort = new InsertionSort();

			break;

		}
		for (int i = 0; i < numberOfTimes; i++) {
			array = createArray(arrayType, arraySize);
			long start = System.nanoTime();
			sort.sort(array);
			long end = System.nanoTime();
			((TestTimes) sort).addTestTime(end - start);
		}

		if (sortType == DriverInterface.SortType.BubbleSort) {
			BubbleSort bs = new BubbleSort();
			displayTestTimes(bs, arrayType, arraySize);
		}
		return (TestTimes) sort;
	}

	private void displayTestTimes(BubbleSort bs, DriverInterface.ArrayType arrayType,
			int arraySize) {

	}

}