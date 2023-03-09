import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        NumericLock obj = new NumericLock();
        ArrayList<int[]> validGuesses = new ArrayList<>();

        // Start measuring time
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            int[] guess = { i / 100, (i / 10) % 10, i % 10 };
            if (obj.evaluate(guess)) {
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
            for (int[] valid : validGuesses) {
                System.out.print("\n" + valid[0] + "-" + valid[1] + "-" + valid[2]);
            }
        }
        System.out.println();
        System.out.println("\nDuration: " + duration + " ms");
        System.out.println();
    }
}
