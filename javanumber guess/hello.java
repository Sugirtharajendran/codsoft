import java.util.Random;
import java.util.Scanner;

public class hello {

    
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0; 

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.printf("I will pick a number between %d and %d.%n", MIN_RANGE, MAX_RANGE);
        System.out.printf("You have %d attempts to guess it correctly.%n", MAX_ATTEMPTS);
        
      
        boolean playAgain = true;
        while (playAgain) {
            totalScore += playRound(scanner);

            System.out.println("\n-------------------------------------------");
            System.out.printf("Current Total Rounds Won: %d%n", totalScore); 
            System.out.println("Do you want to play another round? (yes/no)");
            String choice = scanner.next().toLowerCase();
            playAgain = choice.startsWith("y");
        }

        System.out.println("\nThank you for playing!");
        System.out.printf("Your final score is: %d rounds won!%n", totalScore);
        scanner.close();
    }

    
    public static int playRound(Scanner scanner) {
        Random random = new Random();
        
       
        int generatedNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("\n*** Starting New Round! ***");

      
        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            attempts++;
            System.out.printf("Attempt %d of %d. Enter your guess: ", attempts, MAX_ATTEMPTS);

            
            int userGuess;
           
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine(); 
                attempts--; 
                continue;
            }

           
            if (userGuess == generatedNumber) {
                System.out.printf(" CONGRATULATIONS! You guessed the number %d in %d attempts!%n", generatedNumber, attempts);
                guessedCorrectly = true;
               
                return 1; 
            } else if (userGuess < generatedNumber) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }
        }

      
        if (!guessedCorrectly) {
            System.out.printf("\n You ran out of attempts! The number was %d.%n", generatedNumber);
           
            return 0; 
        }
        
        return 0; 
    }
}