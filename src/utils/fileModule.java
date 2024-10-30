package utils;
import java.io.*;
import java.util.*;

public class fileModule {
	
	public static void writeToFile(String[] saveFile) throws FileNotFoundException{
		PrintStream output = new PrintStream(new File("save_files.txt"));
		for (int i = 0; i < saveFile.length; i++){
			if (i == 5){
				output.print(saveFile[i]); //stores the last element without space
			}

			output.print(saveFile[i] + " ");
		}

		output.println();
		output.close();
	}

	public static  List<String[]> readFromFile() throws FileNotFoundException{
		//list that stores arrays
		List<String[]> saveFiles = new ArrayList<String[]>();

		Scanner input = new Scanner(new File("save_files.txt"));

		//loop to get save data from the whole file
		while (input.hasNextLine()){
			String line = input.nextLine();//stores the whole line
			String[] SaveFile = line.split(" ");//breaks down a line into elements 

			saveFiles.add(SaveFile);
		}
		input.close();
		return saveFiles;
	}
}
