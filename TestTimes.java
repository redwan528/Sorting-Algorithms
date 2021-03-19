
public class TestTimes implements TestTimesInterface {

	private long[] testTimes = new long[10];
	private int index=-1; //-1 means there's nothing in the array right now
	
	
	
	
	@Override
	public long getLastTestTime() {
		if (index != -1) {
			return this.testTimes[index];
		}else {
			return -1;
		}
		
	}

	@Override
	public long[] getTestTimes() { //getTestTimes says return to me the array of testTimes
		long[]array = new long[10]; //copy of an array, not the original array
		for(int i=0; i<this.testTimes.length; i++) {
			array[i]=this.testTimes[i];
		}
		return array;
	}

	@Override
	public void resetTestTimes() { 
		for(int i=0; i<this.testTimes.length; i++) {
			this.testTimes[i]=0;
		}
		this.index=-1;
	}

	@Override
	public void addTestTime(long testTime) {
		//what happens when someone gives me more than 10 testTimes since we set 10 as the limit
		if(index==9) { //9 as in the last element
			for(int i =0; i < (testTimes.length-1); i++) { //testTimes.length-1 so that itll go all the way up to 8 not 9
				this.testTimes[i]=this.testTimes[i+1];
			}
			testTimes[9] = testTime;
			
		} else {
			testTimes[++index]= testTime;
		}
		
		
		
	}

	@Override
	public double getAverageTestTime() {
		if(this.index != -1) {
			double total=0;
			for(int i=0; i<=this.index; i++) {
				total+= this.testTimes[i];		
			}
			double average = total/(this.index + 1);
			
			return average;
		}else {
			return 0.0;
		}
	
	}
	

}
