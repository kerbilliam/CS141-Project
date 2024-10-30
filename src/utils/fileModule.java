package utils;
import java.io.*;

public class fileModule {
	
	public static void writeToFile(String[] saveFile) throws FileNotFoundException{
		PrintStream output = new PrintStream(new File("save_files.txt"));
		for (int i = 0; i < saveFile.length; i++){
			output.print(saveFile[i]);
		}

		output.println();
		output.close();
	}
}
