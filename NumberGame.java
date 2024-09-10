import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 7;
    private static int roundsWon = 0;
    private static int totalAttempts = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playRound(scanner);
            playAgain = askPlayAgain(scanner);
        } while (playAgain);

        displayFinalScore();
        scanner.close();
    }

    private static void playRound(Scanner scanner) {
        int numberToGuess = generateRandomNumber();
        int attempts = 0;

        System.out.println("Guess the number between " + MIN + " and " + MAX + ":");

        while (attempts < MAX_ATTEMPTS) {
            int userGuess = getUserGuess(scanner);
            totalAttempts++;
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the correct number!");
                roundsWon++;
                return;
            }
        }

        System.out.println("Sorry, you've run out of attempts. The number was: " + numberToGuess);
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(MAX - MIN + 1) + MIN;
    }

    private static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        return scanner.nextInt();
    }

    private static boolean askPlayAgain(Scanner scanner) {
        System.out.println("Play again? (yes/no)");
        scanner.nextLine();
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

    private static void displayFinalScore() {
        System.out.println("Game Over! Rounds Won: " + roundsWon + ", Total Attempts: " + totalAttempts);
    }
}
