package Experiment;

import java.util.ArrayList;

public class A {
    public static void main(String[] args) {
        E obj = new E();
        ArrayList<int[]> validGuesses = new ArrayList<>();

        // Start measuring time
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    int[] guess = { i, j, k };
                    if (obj.evaluate(guess)) {
                        validGuesses.add(guess);
                    }
                }
            }
        }
        // End measuring time
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        if (validGuesses.isEmpty()) {
            System.out.println("No valid guesses found.");
        } else {
            System.out.println("\nValid guesses:");
            for (int[] valid : validGuesses) {
                obj.printGuess(valid);
                System.out.println();
            }
        }
        // Print duration
        System.out.println("\nDuration: " + duration + " ms");
    }
    
}
