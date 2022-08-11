package part1;

import java.io.File;

public class FileWatcher implements Runnable {
	private File mainFolder;
	private int folderLength;

	public FileWatcher(File mainFolder) {
		super();
		this.mainFolder = mainFolder;
		this.folderLength = mainFolder.listFiles().length;
	}

	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		for (; !thr.isInterrupted();) {
			int folderCurrentLength = mainFolder.listFiles().length;
			if (folderLength != folderCurrentLength) {
				if (folderLength > folderCurrentLength) {
					System.out.println("Some file(s) was deleted");
					folderLength = folderLength - 1;
				} else {
					System.out.println("Some file(s) was added");
					folderLength = folderLength + 1;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
		System.out.println("File watcher was stoped");

	}

}
