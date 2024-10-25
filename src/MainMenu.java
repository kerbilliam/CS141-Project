import java.util.*;

public class MainMenu {
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

                if (user_input == 1){
                    System.out.println("Level 1");  
                }
                else if (user_input == 2){
                    System.out.println("Level 2");
                }
                else if (user_input == 3){
                    System.out.println("Level 3");
                }
                else if (user_input == 4){
                    System.out.println("Level 4");
                }
                else if (user_input == 5){
                    System.out.println("Exiting levels menu");
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

    public static void main(String[] args) {
        //variables
        boolean exitProgram = false;
        String commandMenu = """
        Command Menu
        1: Levels
        2: Leaderboard
        3: Export score
        4: Help
        5: Exit 
        """;

        //objects
        Scanner console = new Scanner(System.in);

        System.out.println("\nWelcome to Angry Birds Clone!\n" + commandMenu);
        //main menu loop
        while (!exitProgram){
            try {
                System.out.print("Enter the command: ");
                
                int user_input = console.nextInt();

                if (user_input == 1){//levels
                    levelMenu(console);  
                }
                else if (user_input == 2){
                    System.out.println("none");
                }
                else if (user_input == 3){
                    System.out.println("none");
                }
                else if (user_input == 4){
                    System.out.println("Thanks for playing!");
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

