package utils;
import java.io.*;
import java.util.*;

public class fileModule {
	
	public static void appendToFile(String[] saveFile) throws FileNotFoundException{
		PrintStream output = new PrintStream(new FileOutputStream("save_files.txt", true));//appends a new save file.
		for (int i = 0; i < saveFile.length; i++){
			if (i == 8){
				output.print(saveFile[i]+"\n"); //stores the last element without space
			} else{
				output.print(saveFile[i] + " ");
			}
			
		}

		output.close();
	}

	//function to overwrite a specific line in the .txt file 

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
