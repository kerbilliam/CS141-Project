import java.io.FileNotFoundException;
import java.util.*;
import utils.*;

public class MainMenu {
    //creates an array which would store the current user's save data
    public static String[] currentSaveFile = new String[9];
    public static List<String[]> saveFiles = new ArrayList<String[]>();

    public static void userLogin(Scanner console) throws FileNotFoundException{
        boolean userLogin = false;
        String userName = "";

        while(!userLogin){
                System.out.print("Enter username: ");
                userName = console.nextLine();
                saveFiles = fileModule.readFromFile(); //gets save files
                boolean saveFileFound = false;
                while (!saveFileFound) {
                    String[] tempSaveFile = new String[9]; //used to unpack each element of the list to check for the file name
                    for (int i = 0; i < saveFiles.size(); i++){
                        tempSaveFile = saveFiles.get(i);
                        if (tempSaveFile[0].equals(userName)){//if save file with user name exists
                            System.out.println("Save file found. Importing data...");
                            currentSaveFile = saveFiles.get(i);
                            System.out.println("Save file imported succesfully.\n");
                            saveFileFound = true;
                            break;
                        }
                    }
                    
                    if (!saveFileFound){
                        System.out.println("Save file wasn't found. Creating new save file...");
                        //if cant find create a new array with the username and store it in the file
                        currentSaveFile[0] = userName;
                        currentSaveFile[1] = "Incomplete";  //level 1
                        currentSaveFile[2] = "0";   //level 1 score
                        currentSaveFile[3] = "Incomplete";  //level 2
                        currentSaveFile[4] = "0"; //level 2 score
                        currentSaveFile[5] = "Incomplete";  //level 3
                        currentSaveFile[6] = "0"; //level 3 score
                        currentSaveFile[7] = "Incomplete";  //level 4
                        currentSaveFile[8] = "0"; //level 4 score
                        saveFileFound = true; //stops the loop
                        System.out.println("Save file created succesfully.");
                        }
                    }
                userLogin = true;//stops the login loop
                }
                
                
                
        }

    public static void levelSelection(int level){
        if (level == 1){
            //code to run drawing panel for level 1 with its engine 
        }
        else if (level == 2){
            //code to run drawing panel for level 2 with its engine 
        }
        else if (level == 3){
            //code to run drawing panel for level 3 with its engine 
        }
        else if (level == 4){
            //code to run drawing panel for level 4 with its engine 
        }
    }

    public static void levelMenu(Scanner console) {
        //variables
        boolean exitLevelMenu = false;
        String levelMenu = """
        Levels Available
        1: Level 1
        2: Level 2
        3: Level 3
        4: Level 4
        5: Exit
        """;

        System.out.println(levelMenu);
        //level menu loop
        while (!exitLevelMenu){
            try {
                System.out.print("Enter the level number: ");
                int user_input = console.nextInt();

                if (user_input == 1 || user_input == 2 || user_input == 3 || user_input == 4 ){
                    System.out.println("Selected Level " + user_input);  
                    levelSelection(user_input);
                }

                else if (user_input == 5){
                    System.out.println("Exiting levels menu\n");
                    exitLevelMenu = true;
                }

                else{//for integer which are outside command numbers bound
                    System.out.println("Invalid level number. Enter an integer number corresponding to a level.");
                }   
            
            } catch (InputMismatchException e) {//Scanner built-in exception 
                System.out.println("Invalid input type. Please enter an integer.");
                console.next();//need this to prevent infinite loop
            }          
        }
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        //variablesd
        boolean exitProgram = false;
        String commandMenu = """
        Command Menu
        1: Levels
        2: Leaderboard
        3: Help
        4: Exit
        """;
        String helpCommand = """     
        Help Menu Info
        Levels: opens a menu page to select a level. When you select a level the app launches drawing panel and prompts you to enter angle and velocity.
        """;
        //objects
        Scanner console = new Scanner(System.in); //only one scanner object for whole app since when closing a scanner its input stream(System.in) closes for the whole app

        //test
        userLogin(console);

        System.out.println("\nWelcome to Angry Birds Clone!\n" + commandMenu);
        //main menu loop
        while (!exitProgram){
            try {
                System.out.print("Enter the command: ");
                
                int user_input = console.nextInt();

                if (user_input == 1){//levels
                    System.out.println();
                    levelMenu(console);  
                }

                else if (user_input == 2){//leaderboard
                    System.out.println("none");
                }

                else if (user_input == 3){//help 
                    System.out.println("\n" + helpCommand);
                }

                else if (user_input == 4){//quit app
                    System.out.println("Thanks for playing!");
                    //if a file exists we overwrite it in the text file to store new data
                    //function to do that
                    //if a file doesn't exist we append it to the text file
                    fileModule.appendToFile(currentSaveFile);
                    exitProgram = true;
                }
                else{//for integer which are outside command numbers bound
                    System.out.println("Invalid command number. Enter an integer number corresponding to a command.");
                }   
            
            } catch (InputMismatchException e) {//Scanner built-in exception 
                System.out.println("Invalid input type. Please enter an integer.");
                console.next();//need this to prevent infinite loop
            }          
        }
        //closes console to prevent leakage
        console.close();
    }
    
}

