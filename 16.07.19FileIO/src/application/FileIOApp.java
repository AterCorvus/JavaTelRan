package application;

import java.io.File;
import java.io.IOException;

public class FileIOApp {
	public static void main(String[] args) throws IOException {
		File file = new File("test1.txt");
		file.createNewFile();
		}
}
