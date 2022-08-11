package part1;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
//		100 Threads
		Thread[] thArr = new Thread[100];
		
		for (int i = 0; i < thArr.length; i++) {
			thArr[i] = new Thread(new FactorialThread(i));
		}
		
		for (int i = 0; i < thArr.length; i++) {
			thArr[i].start();
		}
		
		System.out.println("main is stoped");
		
		
//		Sum of arr
		SumCalc sc = new SumCalc();
		sc.getThreadSum();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {	
			e.printStackTrace();
		}
		sc.setMainSum(0);
		sc.getSum();
		
		
//		Copy files
		File f1 = new File("example");
		File f2 = new File("example2");
		
		CopyFolder.copyFiles(f1, f2);

//		Folder watcher
		File folder = new File("example");
		
		Thread thrNew = new Thread(new FileWatcher(folder));
		thrNew.start();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {	
			e.printStackTrace();
		}
		thrNew.interrupt();
		
	}

}
