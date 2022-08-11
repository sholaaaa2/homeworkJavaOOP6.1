package part1;

public class SumCalc {
	private int[] intArr = new int[200000000];
	private int mainSum = 0;

	public SumCalc(int[] intArr) {
		super();
		this.intArr = intArr;
	}

	public SumCalc() {
		super();
		generateArr();
	}

	private void generateArr() {
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = (int) (Math.random() * 10);
		}
	}

	public int getMainSum() {
		return mainSum;
	}
	
	public void setMainSum(int mainSum) {
		this.mainSum = mainSum;
	}

	public void getThreadSum() {
		long timeStart = System.currentTimeMillis();
		int size = intArr.length / 5;
		SumThread[] thrArr1 = new SumThread[5];
		Thread[] thrArr2 = new Thread[5];

		for (int i = 0; i < thrArr2.length; i++) {
			int begin = i * size;
			int end = begin + size;
			thrArr1[i] = new SumThread(intArr, begin, end);
			thrArr2[i] = new Thread(thrArr1[i]);
			thrArr2[i].start();
		}
		for (int i = 0; i < thrArr2.length; i++) {
			try {
				thrArr2[i].join();
				mainSum += thrArr1[i].getSum();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("Main sum is "+ mainSum+". Neded time = " + (timeEnd- timeStart));
	}
	
	public void getSum() {
		long timeStart = System.currentTimeMillis();
		for (int i = 0; i < intArr.length; i++) {
			this.mainSum += this.intArr[i]; 
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("Main sum is "+ mainSum+". Neded time = " + (timeEnd- timeStart));
	}
}
