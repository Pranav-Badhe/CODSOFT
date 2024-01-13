import java.util.Scanner;
import java.util.Random;

public class Number_game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randomNumber = new Random();

        int minimumRange = 1;
        int maximumRange = 100;
        int maxAttempts = 5;
        int roundsPlayed = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("I have selected a number between " + minimumRange + " and " + maximumRange);

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = randomNumber.nextInt(maximumRange - minimumRange + 1) + minimumRange;
            int attempts = 0;
            boolean correctGuess = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guessNum = sc.nextInt();
                attempts++;

                if (guessNum == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    correctGuess = true;
                    score++;
                    break;
                } else if (guessNum < targetNumber) {
                    System.out.println("Too low! Try a bigger number.");
                } else {
                    System.out.println("Too high! Try a smaller number.");
                }
            }

            if(!correctGuess)
            {
                System.out.println("Sorry!! You ran out of attempts");
                System.out.println("The number was: "+targetNumber);
            }

            roundsPlayed++;
            System.out.print("Do you want to play again? (y/n): ");
            String playAgainResponse = sc.next().toLowerCase();

            if (!playAgainResponse.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over! You played " + roundsPlayed +  " rounds");
        System.out.println("Your Score is: "+score);

        sc.close();
    }
}

