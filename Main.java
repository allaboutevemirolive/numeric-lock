import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        NumericLock numericLock = new NumericLock();
        ArrayList<int[]> validGuesses = new ArrayList<>();

        // Start measuring time
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            int[] guess = { i / 100, (i / 10) % 10, i % 10 };
            if (numericLock.evaluate(guess)) {
                validGuesses.add(guess);
            }
        }

        // End measuring time
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        if (validGuesses.isEmpty()) {
            System.out.println("No valid guesses found.");
        } else {
            System.out.println();
            System.out.print("\nValid guesses:");
            for (int[] validGuess : validGuesses) {
                System.out.print("\n" + validGuess[0] + "-" + validGuess[1] + "-" + validGuess[2]);
            }
        }
        System.out.println();
        System.out.println("\nDuration: " + duration + " ms");
        System.out.println();
    }
}