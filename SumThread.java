package part1;

public class SumThread implements Runnable {
	private int sum = 0;
	private int[] numArr;
	private int begin;
	private int end;
	
	
	public SumThread(int[] numArr, int begin, int end) {
		super();
		this.numArr = numArr;
		this.begin = begin;
		this.end = end;
	}


	public int getSum() {
		return sum;
	}


	private void calculateSum() {
		for (int i = begin; i < end; i++) {
			this.sum += this.numArr[i]; 
		}
	}
	

	@Override
	public void run() {
		calculateSum();
	}

}
