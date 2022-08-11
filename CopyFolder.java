package part1;

import java.io.File;

public class CopyFolder {
	public static void copyFiles(File startFolder, File newFolder) {
		File[] startFiles = startFolder.listFiles();
		for (File file : startFiles) {
			if (file.isFile()) {
				File f = new File(newFolder, file.getName());
				Thread tr = new Thread(new FileOperationThread(file, f));
				tr.start();
			}
		}
	}

}
