package part1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperationThread implements Runnable {
	private File inFile;
	private File outFile;

	public FileOperationThread(File inFile, File outFile) {
		super();
		this.inFile = inFile;
		this.outFile = outFile;
	}

	private void fileCopy(File in, File out) throws IOException {
		byte[] buffer = new byte[1024 * 1024];
		int readByte = 0;
		try (FileInputStream fis = new FileInputStream(in); FileOutputStream fos = new FileOutputStream(out)) {
			for (; (readByte = fis.read(buffer)) > 0;) {
				fos.write(buffer, 0, readByte);
			}
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public void run() {
		try {
			fileCopy(inFile, outFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
