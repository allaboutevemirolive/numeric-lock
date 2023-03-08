package Experiment;
public class C {

    private final int[] clueCombo1 = {6, 8, 2};
    private final int[] clueCombo2 = {6, 1, 4};
    private final int[] clueCombo3 = {2, 0, 6};
    private final int[] clueCombo4 = {7, 3, 8};
    private final int[] clueCombo5 = {3, 8, 0};

    public void solve() {
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                if (b == a) continue;
                for (int c = 0; c < 10; c++) {
                    if (c == b || c == a) continue;
                    int[] guess = {a, b, c};
                    if (rule1(guess) && rule2(guess) && rule3(guess) && rule4(guess) && rule5(guess)) {
                        printGuess(guess);
                        System.out.println(" ====================");
                    }
                }
            }
        }
    }

    private boolean rule1(int[] guess) {
        return numMatchesInPlace(guess, clueCombo1) == 1 && numDigitsRight(guess, clueCombo1) == 1;
    }

    private boolean rule2(int[] guess) {
        return numMatchesInPlace(guess, clueCombo2) == 0 && numDigitsRight(guess, clueCombo2) == 1;
    }

    private boolean rule3(int[] guess) {
        return numMatchesInPlace(guess, clueCombo3) == 0 && numDigitsRight(guess, clueCombo3) == 2;
    }

    private boolean rule4(int[] guess) {
        return numDigitsRight(guess, clueCombo4) == 0;
    }

    private boolean rule5(int[] guess) {
        return numMatchesInPlace(guess, clueCombo5) == 0 && numDigitsRight(guess, clueCombo5) == 1;
    }

    private int numMatchesInPlace(int[] guess, int[] clueCombo) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == clueCombo[i]) {
                count++;
            }
        }
        return count;
    }

    private int numDigitsRight(int[] guess, int[] clueCombo) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (guess[i] == clueCombo[j] && i != j) {
                    count++;
                }
            }
        }
        return count;
    }

    private void printGuess(int[] guess) {
        System.out.println(guess[0] + "-" + guess[1] + "-" + guess[2]);
    }
}
