import java.util.Random;
import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int guessingnumber = random.nextInt(100) + 1; 
        int guess;
        int attempts = 0;

        System.out.println(" Welcome to the Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");

        do {
            System.out.print("Enter your guessing number: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess > guessingnumber) {
                System.out.println(" very high! Try again.");
            } else if (guess < guessingnumber) {
                System.out.println(" very low! Try again.");
            } else {
                System.out.println("Correct! The number was " + guessingnumber);
                System.out.println("You guessed it in " + attempts + " attempts.");
            }
        } while (guess != guessingnumber);

        scanner.close();
    }
}
