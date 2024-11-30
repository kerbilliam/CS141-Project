import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.sound.sampled.*;


import physics.Physics;
import utils.*;
import levelDesign.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MainMenu {    
    public static Scanner console = new Scanner(System.in); //only one scanner object for whole app since when closing a scanner its input stream(System.in) closes for the whole app
    //creates an array which would store the current user's save data
    public static String[] currentSaveFile = new String[9];
    public static List<String[]> saveFiles = new ArrayList<String[]>();
    //position of the array save in saves file 
    public static int saveFilePosition = -1;
    
    public static void userLogin(Scanner console) throws FileNotFoundException{
        /**
         * Prompts the user to enter a username and if a save data with such a name exists imports it. If not creates a new save data instance.
         */
        boolean userLogin = false;
        String userName = "";
    
        while(!userLogin){

                boolean correctUsernameFormat = false;
                //loop to make sure the user doesn't enter a username that contains spaces
                while (!correctUsernameFormat) {
                    System.out.print("Enter username: ");
                    userName = console.nextLine();
                    if(userName.contains(" ")){
                        System.out.print("Enter a username that doesn't contain any spaces.\n");
                    }else{
                        correctUsernameFormat = true;
                    }
                }
                
                saveFiles = fileModule.readFromFile(); //gets save datas
                boolean saveFileFound = false;
                while (!saveFileFound) {
                    String[] tempSaveFile = new String[9]; //used to unpack each element of the list to check for the save data name
                    for (int i = 0; i < saveFiles.size(); i++){
                        tempSaveFile = saveFiles.get(i);
                        if (tempSaveFile[0].equals(userName)){//if save data with user name exists
                            System.out.println("Save file found. Importing data...");
                            currentSaveFile = saveFiles.get(i);//assigns the save file data(array)
                            saveFilePosition = i; //asigns the line number of the save data, so it can be overwritten later to save user's progress when they exit the app
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
    
    public static void levelMenu() {
        /**
         * Shows the  user level menu commands and prompts them for input.
         */
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
                System.out.print("Enter the level command number: ");
                int user_input = console.nextInt();

                if (user_input == 5){
                    System.out.println("Exiting levels menu\n");
                    exitLevelMenu = true;
                }

                else if (user_input == 1 || user_input == 2 || user_input == 3 || user_input == 4 ){
                    System.out.println("Selected Level " + user_input);  
                    Physics.currentLevel = user_input; // tell physics class which level is selected
                    levelSelection(user_input);
                    System.out.println(levelMenu);
                }

                else{//for integer which are outside command numbers bound
                    System.out.println("Invalid level number. Enter an integer number corresponding to a level.");
                }   
            
            } catch (InputMismatchException e) {//Scanner built-in exception 
                System.out.println("Invalid input type. Please enter an integer.");
                console.nextLine();//need this to prevent infinite loop. 
                //I had to change to nextLine because the buffer in console holds the invalid inputs in a line and with just next() it would only delete one token from the buffer line, 
                // so if there was two invalids then after next() there would be another one in the line that needs to be deleted before the user can exit the menu, causing them to enter exit command multiple times.
                //With nextLine() the whole buffer line get cleaned, so user only need to enter exit command one time.
                         
            }
        }
    }

    public static void levelSelection(int level){
        /**
         * Starts a level based on parameter value given.
         */
        if (level == 1){           
            //code to run drawing panel for level 1 with its engine
            // need to copy working panel and graphics to physics
            WorkInProgress.level1();
            Physics.currentLevel = level;
            Physics.workingPanel = WorkInProgress.panel;
            Physics.workingGraphics = WorkInProgress.g;
            runLevel(level); 
        }
        else if (level == 2){
            WorkInProgress2.levelTwo();
            runLevel(level);
            //code to run drawing panel for level 2 with its engine 
        }
        else if (level == 3){
            WorkInprogress3.levelThree();
            runLevel(level);
            //code to run drawing panel for level 3 with its engine 
        }
        else if (level == 4){
            WorkInProgress4.levelFour();
            runLevel(level);
            //code to run drawing panel for level 4 with its engine 
        }
    }

    public static void runLevel(int level) {
        boolean userInLevelLoop = true;
        while (userInLevelLoop) {
            try {
                //physics input
                System.out.print("Enter angle: ");
                Physics.inputAngle = (double) console.nextDouble();
                System.out.print("Enter velocity: ");
                Physics.inputVelocity = (double) console.nextDouble();

                //draws panel and projected trajactory
                Physics.workingPanel.clear();
                //chooses level specific panel
                if (Physics.currentLevel == 1) WorkInProgress.level1();
                if (Physics.currentLevel == 2) WorkInProgress2.levelTwo();
                if (Physics.currentLevel == 3) WorkInprogress3.levelThree();
                if (Physics.currentLevel == 4) WorkInProgress4.levelFour();
                Physics.tradjectTest();

                userInLevelLoop = levelRunConfirmation(level);
            
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type for velocity or angle. Please enter a numeric value.");
                console.nextLine();//need this to prevent infinite loop. 
            }
        }

    }
    
    public static boolean levelRunConfirmation(int level) {
        //loop for confirmation
        while (true){
            System.out.print("Confirm this trajectory? Yes/No: ");
            String confirmation = (console.next().toLowerCase());
            if (confirmation.equals("yes")){
                
                //draw level based on level number
                Physics.workingPanel.clear();
                if (Physics.currentLevel == 1) WorkInProgress.level1();
                if (Physics.currentLevel == 2) WorkInProgress2.levelTwo();
                if (Physics.currentLevel == 3) WorkInprogress3.levelThree();
                if (Physics.currentLevel == 4) WorkInProgress4.levelFour();

                Physics.play(); //takes level number as parameter and then in physics uses this parameter to determine what collision to use
                System.out.println();
                return false;//stops user in level loop
            }else if (confirmation.equals("no")){
                //loop back
                System.out.println("Alright, lets try again.");
                break;
            }
            else{
                System.out.println("Invalid confirmation command. Try again.");
            }
        }
                return true;
    }

    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException {

        // audio!!
        File file = new File("src/AudioANDfailScreen/Angry Birds Theme Song.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        /**
         * Main method which runs the app.
         */
        //variables
        boolean exitProgram = false;
        String commandMenu = """
        Command Menu
        1: Levels
        2: Leaderboard 
        3: Help
        4: Exit
        """;
        //Why do we need export? Is it essential? what does it add to the project?
        String helpCommand = """     
        Help Menu Info
        Levels: opens a menu page to select a level. When you select a level the app launches drawing panel and prompts you to enter angle and velocity.
        """;
        
        

        //User login prompt
        userLogin(console);

        System.out.println("\nWelcome to Angry Birds Clone!\n" + commandMenu);
        //main menu loop
        while (!exitProgram){
            try {
                System.out.print("Enter the command: ");
                
                int user_input = console.nextInt();

                if (user_input == 1){//levels
                    System.out.println();
                    levelMenu();  
                    System.out.println(commandMenu);
                }

                else if (user_input == 2){//leaderboard
                    System.out.println("none");
                }

                else if (user_input == 3){//help 
                    System.out.println("\n" + helpCommand);
                }

                else if (user_input == 4){//quit app
                    System.out.println("Thanks for playing!");
                    if(saveFilePosition == -1){//the save data was created during this app instance so we append it
                        fileModule.appendToFile(currentSaveFile);
                    }else{//the save data was imported, so we must overwrite the old save data to store user's progress 
                        saveFiles.set(saveFilePosition, currentSaveFile);
                        fileModule.overWriteFile(saveFiles);
                    }
                    
                    exitProgram = true;
                }
                else{//for integer which are outside command numbers bound
                    System.out.println("Invalid command number. Enter an integer number corresponding to a command.");
                }   
            
            } catch (InputMismatchException e) {//Scanner built-in exception 
                System.out.println("Invalid input type. Please enter an integer.");
                console.nextLine();//need this to prevent infinite loop
            }          
        }
        //closes console to prevent leakage
        console.close();
    }
    
}

