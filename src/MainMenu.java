import java.util.*;

public class MainMenu {
    public static void main(String[] args) {
        //variables
        boolean exitProgram = false;
        String commandMenu = """
        Command Menu
        1: Levels
        2: Leaderboard
        3: Export score
        4: Exit 
        """;

        //objects
        Scanner console = new Scanner(System.in);

        System.out.println("\nWelcome to Angry Birds Clone!\n" + commandMenu);
        //main menu loop
        while (!exitProgram){
            try {
                System.out.print("Enter the command: ");
                int user_input = console.nextInt();

                if (user_input == 1){
                    System.out.println("none");
                    
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

