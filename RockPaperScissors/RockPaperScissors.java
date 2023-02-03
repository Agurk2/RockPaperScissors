import java.lang.Math;
import java.util.Random;
import java.util.Scanner;
/**
 * This class will allow the user to play Rock, Paper And Scissors.
 * The user will be able to play as many games as he/she likes.
 * They will be able to exit the program at any one point they like.
 *
 * @author Onorregaard
 * @version 0.01
 */
public class RockPaperScissors
{
    // Used to compare the user choice with computer choice
    private int userIntInput;
    // Stores the computer choice
    private int computerIntChoice;
    // Helps convert int to string
    private String computerChoice;
    // Helps store the user choice in a readable format
    private String userInputWord;
    // Stores the score for the user
    private int userScore;
    // Stores the score for the computer
    private int computerScore;
    // Stores the value of how many games the user has played
    private int gameCount;
    /**
     * Constructor for objects of class RockPaperScissors
     */
    public RockPaperScissors()
    {
        // initialise instance variables
        userIntInput = 0;
        userScore = 0;
        computerScore = 0;
        gameCount = 0;
        // Put in the method to play to allow the terminal to popup as soon as they call the class onto the bench.
        play();
    }

    /**
     * This method allows the user to choose rock, paper or scissors.
     * It will then store that value in an integer format to easily
     * compare the results in getObject.
     *
     * Precondition: any
     * 
     * Postcondition: the user will have chosen either rock, paper or 
     * scissors. If they choose to stop the program, the program will be
     * terminated.
     * 
     */
    private void chooseObject() 
    {
        //ask the user if they want R P or S
        System.out.println("Choose your object!");
        Scanner scanner = new Scanner(System.in);
        String keyboard = scanner.nextLine();
        userInputWord = keyboard;
        keyboard = keyboard.substring(0, 1).toUpperCase() + keyboard.substring(1);
        // These if statements allow the program to assing int values for comparison between userInput and computerInput.
        if (keyboard.equals("Rock")) {
            System.out.println("You chose: " + keyboard);
            userIntInput = 1;
        }
        else if (keyboard.equals("Scissors")) {
            System.out.println("You chose: " + keyboard);
            userIntInput = 2;
        }
        else if (keyboard.equals("Scissor")) {
            System.out.println("You chose: " + keyboard);
            userIntInput = 2;
        }

        else if (keyboard.equals("Paper")) {
            System.out.println("You chose: " + keyboard);
            userIntInput = 3;
        }
        else if(keyboard.equals("Stop")) {
            System.out.println("Thanks for playing! I hope you had fun");
            System.exit(0);
        }
        else {
            System.out.println("You must choose either Rock, Paper or Scissors!");
            chooseObject();
        }
    }

    /**
     * This method allows the program to compare the results from
     * userIntInput and computerIntChoice. It will then print out
     * the results and the current score.
     * 
     * Precondition: method chooseObject must've been called beforehand
     * to allow user input. Method computerChooseObject must've been called
     * beforehand to allow computer input.
     * 
     * Postcondition: the values from chooseObject and computerChooseObject
     * will have been compared and a result will have been printed.
     * It will also display the current score.
     */
    private void getResults()
    {
        // The two choice will be compared and points will be assigned.
        if(userIntInput == computerIntChoice) {
            System.out.println("It's a tie!");
        }
        else if(userIntInput == 1 && computerIntChoice == 3) {
            System.out.println("You loose");
            computerScore++;
        }
        else if(userIntInput == 2 && computerIntChoice == 1) {
            System.out.println("You loose");
            computerScore++;
        }
        else if(userIntInput == 3 && computerIntChoice == 2) {
            System.out.println("You loose");
            computerScore++;
        }
        else {
            System.out.println("You win!");
            userScore++;
        }
        // After it has shown wheter you won or not, it will print the score.
        System.out.println("The score is " + userScore + "-" + computerScore);
        System.out.println();
    }

    /**
     * This is the main run method for the program. It will allow
     * the user to play a simulation of rock, paper and scissors.
     * 
     * Precondition: any
     * 
     * Postcondition: The program will have stopped.
     */
    private void play() 
    {
        // If the user has played more than once, the program will keep going until the user stops it.
        if(gameCount > 0) {
            chooseObject();
            computerChooseObject();
            getResults();
            play();
        }
        // If it's the first time the user plays, it will ask if he/she wants to play
        else if(gameCount == 0) {
            System.out.println("Welcome to the great game of Rock, Paper And Scissors");
            System.out.println("To stop the game, type in Stop") ;
            System.out.println("Do you want to play?");
            Scanner scanner = new Scanner(System.in);
            String keyboard = scanner.nextLine();
            keyboard = keyboard.substring(0, 1).toUpperCase() + keyboard.substring(1);
            if(keyboard.equals("Yes")) {
                chooseObject();
                computerChooseObject();
                getResults();
                gameCount++;
                play();
            }
            // If the user doesn't want to play, it will stop.
            else if(keyboard.equals("No")){
                System.out.println("Okay, maybe another time then...");
            }
        }
    }

    /**
     * This method allows the program to randomly choose rock, paper 
     * or scissors. 
     * 
     * Precondition: any
     * 
     * Postcondition: the computer will have chosen, at random, either
     * rock, paper or scissors and stored it in the variable
     * computerChoice.
     */
    private void computerChooseObject()
    {
        getRandomNumber();
        // Afther the computer has gotten a random number, it will assign it to a string.
        if(computerIntChoice == 1) {
            computerChoice = "Rock";
            System.out.println("The computer chose: " + computerChoice);
        }
        if(computerIntChoice == 2) {
            computerChoice = "Scissors";
            System.out.println("The computer chose: " + computerChoice);
        }
        if(computerIntChoice == 3) {
            computerChoice = "Paper";
            System.out.println("The computer chose: " + computerChoice);
        }
    }

    /**
     * This method allows the program to generate a random number, between
     * and including 1-3. This integer allows the program to randomly
     * choose rock, paper or scissors, to accurately represent real life
     * scenario.
     * 
     * Precondition: any
     * Postcondition: a random value will have been assigned 
     * to randomNumber.
     */
    private void getRandomNumber()
    {
        computerIntChoice = (int)(Math.random()*((4-1))+1);
    }
}
