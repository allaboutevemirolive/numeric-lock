import java.util.ArrayList;

public class NumericLock {

    // Returns the number of elements in a that are in the same position as the corresponding element in b.
    public int numMatchesInPlace(int[] a, int[] b) {
        int count = 0;
        boolean[] matches = new boolean[a.length];
        // ex. [1,2,3], [3,2,1] => [false, true, false]
        for (int i = 0; i < a.length; i++) {
            matches[i] = (a[i] == b[i]);
        }
        for (boolean match : matches) {
            // if true, increment count to show there is number that in right place
            if (match) {
                count++;
            }
        }
        return count;
    }

    // Returns the number of elements in a that are also in b, regardless of position. (intersection of a and b.)
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

    // One digit is right and in its place
    public boolean rule1(int[] guess) {
        int[] clueCombo = { 6, 8, 2 };
        return (numMatchesInPlace(guess, clueCombo) == 1) && (numDigitsRight(guess, clueCombo) == 1);
    }

    // One digit is right but in the wrong place
    public boolean rule2(int[] guess) {
        int[] clueCombo = { 6, 1, 4 };
        return (numMatchesInPlace(guess, clueCombo) == 0) && (numDigitsRight(guess, clueCombo) == 1);
    }

    // Two digits are right, but both are in the wrong place
    public boolean rule3(int[] guess) {
        int[] clueCombo = { 2, 0, 6 };
        return (numMatchesInPlace(guess, clueCombo) == 0) && (numDigitsRight(guess, clueCombo) == 2);
    }

    // All digits are wrong
    public boolean rule4(int[] guess) {
        int[] clueCombo = { 7, 3, 8 };
        return (numDigitsRight(guess, clueCombo) == 0);
    }

    // One digit is right but in the wrong place
    public boolean rule5(int[] guess) {
        int[] clueCombo = { 3, 8, 0 };
        return (numMatchesInPlace(guess, clueCombo) == 0) && (numDigitsRight(guess, clueCombo) == 1);
    }

    public boolean evaluate(int[] guess) {
        // Prints the guess in the format 'a-b-c'
        System.out.print("\n" + guess[0] + "-" + guess[1] + "-" + guess[2]);
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
