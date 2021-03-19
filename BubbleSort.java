import java.lang.reflect.Array;

public class BubbleSort extends TestTimes implements SortInterface {
	
	

	@Override
	public void sort(Integer[] arrayToSort) {
		
		boolean sorted=false; //assumes the array is unsorted in the first place
		 int n = arrayToSort.length-1;
		
		while(!sorted) {
			sorted=true;
			for(int i=0; i<n; i++) { 
				
				if(arrayToSort[i]>arrayToSort[i+1]) {//if elements r out of order
					swap(arrayToSort, i, i+1);
					
					sorted=false; // since we had to swap, we know array is not sorted
				}
		
				}
		
			n=n-1;
			}
	}

	private void swap(Integer[] arrayToSort, int i, int j) {
		int temp=arrayToSort[i];
		arrayToSort[i]=arrayToSort[j];
		arrayToSort[j]= temp;
		
	}

}
