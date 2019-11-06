import java.util.Random;
import java.util.Scanner;


public class Problem1 {

    private static boolean gameFinish = false;
    private static char LETTER_TO_GUESS;

    private static void inputComparator(char c) {
        c = Character.toLowerCase(c);
        if (!((c >= 'a')&&(c <= 'z'))){
            System.out.println("Your input is incorrect, please enter correct letter...");
        }
        else if (c < LETTER_TO_GUESS) {
            System.out.println("Try once more, " + c + " is too low!");
        } else if (c > LETTER_TO_GUESS) {
            System.out.println("Try once more, " + c + " is too high!");
        } else if (c == LETTER_TO_GUESS) {
            System.out.println("YOU WIN!");
            gameFinish = true;
        }
    }

    public static void setLetterToGuess() {
        Random rng = new Random();
        LETTER_TO_GUESS = (char) (rng.nextInt(26) + 'a');
    }

    public static void startGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Can you guess a letter i made?");
        System.out.println("Type Y to start.");
        String answer = input.next();
        if (answer.toLowerCase().equals("y")) {
            System.out.println("Okay, here we go " + LETTER_TO_GUESS);
            while (!gameFinish) {
                inputComparator(input.next().charAt(0));
            }
        } else {
            System.out.println("Bye.");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        setLetterToGuess();
        startGame();
    }
}