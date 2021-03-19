
public class InsertionSort extends TestTimes implements SortInterface{

	@Override
	public void sort(Integer[] arrayToSort) {
		
		
		for(int i=1; i < arrayToSort.length; ++i) {
			int temp=arrayToSort[i]; //temporary variable container to hold and move element
		
			int j = i-1; //starts from the previous item
			while(j>=0 && arrayToSort[j]>temp) { //
				arrayToSort[j+1]=arrayToSort[j]; //moves element to the right side
			    j=j-1; //decrementing j to shift all items to the right
			
			}
			arrayToSort[j+1]=temp;
		}
		
	}

}

