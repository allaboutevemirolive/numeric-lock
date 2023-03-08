import java.util.ArrayList;

public class NumericLock {

    // Returns a boolean array indicating if each element in a is in the same position as the corresponding element in b.
    public boolean[] matchesInPlace(int[] a, int[] b) {
        boolean[] result = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = (a[i] == b[i]);
        }
        return result;
    }

    // Returns the number of elements in a that are in the same position as the corresponding element in b.
    public int numMatchesInPlace(int[] a, int[] b) {
        int count = 0;
        boolean[] matches = matchesInPlace(a, b);
        for (boolean match : matches) {
            if (match) {
                count++;
            }
        }
        return count;
    }

    // Returns the number of elements in a that are also in b, regardless of position.
    public int numDigitsRight(int[] a, int[] b) {
        ArrayList<Integer> setA = new ArrayList<>();
        for (int num : a) {
            setA.add(num);
        }
        int count = 0;
        for (int num : b) {
            if (setA.contains(num)) {
                count++;
                setA.remove(Integer.valueOf(num));
            }
        }
        return count;
    }

    public boolean rule1(int[] guess) {
        int[] clueCombo = { 6, 8, 2 };
        return (numMatchesInPlace(guess, clueCombo) == 1) && (numDigitsRight(guess, clueCombo) == 1);
    }

    public boolean rule2(int[] guess) {
        int[] clueCombo = { 6, 1, 4 };
        return (numMatchesInPlace(guess, clueCombo) == 0) && (numDigitsRight(guess, clueCombo) == 1);
    }

    public boolean rule3(int[] guess) {
        int[] clueCombo = { 2, 0, 6 };
        return (numMatchesInPlace(guess, clueCombo) == 0) && (numDigitsRight(guess, clueCombo) == 2);
    }

    public boolean rule4(int[] guess) {
        int[] clueCombo = { 7, 3, 8 };
        return (numDigitsRight(guess, clueCombo) == 0);
    }

    public boolean rule5(int[] guess) {
        int[] clueCombo = { 3, 8, 0 };
        return (numMatchesInPlace(guess, clueCombo) == 0) && (numDigitsRight(guess, clueCombo) == 1);
    }

    // Prints the guess in the format 'a-b-c'.
    public void printGuess(int[] guess) {
        System.out.print("\n" + guess[0] + "-" + guess[1] + "-" + guess[2]);
    }

    public boolean evaluate(int[] guess) {
        // Evaluates the guess against all five clues and prints the results.
        printGuess(guess);
        System.out.print(":");
        int fails = 0;
        if (!rule1(guess)) {
            System.out.print(" !r1");
            fails++;
        }
        if (!rule2(guess)) {
            System.out.print(" !r2");
            fails++;
        }
        if (!rule3(guess)) {
            System.out.print(" !r3");
            fails++;
        }
        if (!rule4(guess)) {
            System.out.print(" !r4");
            fails++;
        }
        if (!rule5(guess)) {
            System.out.print(" !r5");
            fails++;
        }
        if (fails == 0) {
            System.out.print(" ====================");
            return true;
        } else {
            return false;
        }
    }
}
