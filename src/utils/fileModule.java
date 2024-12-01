package utils;
import java.io.*;
import java.util.*;

public class fileModule {
	
	public static void appendToFile(String[] saveFile) throws FileNotFoundException{
		/**
		 * Adds a new save data instance to the file.
		 * @param saveFile a string array which represent a new save data.
		 */
		PrintStream output = new PrintStream(new FileOutputStream("save_files.txt", true));//appends a new save file.
		for (int i = 0; i < saveFile.length; i++){
			if (i == 4){
				output.print(saveFile[i]+"\n"); //stores the last element without space
			} else{
				output.print(saveFile[i] + " ");
			}
			
		}

		output.close();
	}

	public static void overWriteFile(List<String[]> saveFiles) throws FileNotFoundException{
		/**
		 * Overwrites old save data.
		 * @param saveFiles a list of string arrays which represent save datas.
		 */
		//this functions overwrites the whole save file. It's inefficient but works.
		PrintStream output = new PrintStream(new File("save_files.txt"));
		for(int i = 0; i <saveFiles.size(); i++){
			String[] saveFile = new String[5]; //used to unpack each element of the list
			saveFile = saveFiles.get(i);
			//writes save file into single line
			for (int j = 0; j < saveFile.length; j++){
				if (j == 4){
					output.print(saveFile[j]+"\n"); //stores the last element without space
				} else{
					output.print(saveFile[j] + " ");
				}
				
			}
			
		}
		output.close();	
	}

	public static  List<String[]> readFromFile() throws FileNotFoundException{
		/**
		 * Reads the save data file and returns save datas.
		 * @return saveFiles which a list that contains string Arrays that represent the save datas.
		 */
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
