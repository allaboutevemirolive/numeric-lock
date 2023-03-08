package Experiment;
import java.util.HashSet;
import java.util.Set;

public class B {

    private int[] combination = new int[3];

    public int[] matchesAndDigitsRight(int[] a, int[] b) {
        int[] result = new int[2];
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }
        for (int num : b) {
            if (setA.contains(num)) {
                result[1]++;
                setA.remove(num);
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                result[0]++;
            }
        }
        result[1] -= result[0];
        return result;
    }

    public boolean rule(int[] guess, int[] clueCombo, int expectedMatches, int expectedDigitsRight) {
        int[] matchesAndDigitsRight = matchesAndDigitsRight(guess, clueCombo);
        return matchesAndDigitsRight[0] == expectedMatches && matchesAndDigitsRight[1] == expectedDigitsRight;
    }

    public boolean evaluate(int[] guess) {
        System.out.print("\n" + guess[0] + "-" + guess[1] + "-" + guess[2] + ":");
        int fails = 0;
        if (!rule(guess, new int[]{6, 8, 2}, 1, 1)) {
            System.out.print(" !r1");
            fails++;
        }
        if (!rule(guess, new int[]{6, 1, 4}, 0, 1)) {
            System.out.print(" !r2");
            fails++;
        }
        if (!rule(guess, new int[]{2, 0, 6}, 0, 2)) {
            System.out.print(" !r3");
            fails++;
        }
        if (!rule(guess, new int[]{7, 3, 8}, 0, 3)) {
            System.out.print(" !r4");
            fails++;
        }
        if (!rule(guess, new int[]{3, 8, 0}, 0, 1)) {
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

    public void solve(int pos) {
        if (pos == combination.length) {
            evaluate(combination);
            return;
        }
        for (int i = 0; i < 10; i++) {
            combination[pos] = i;
            if (isValid(combination, pos)) {
                solve(pos + 1);
            }
        }
    }

    public boolean isValid(int[] guess, int pos) {
        for (int i = 0; i < pos; i++) {
            if (guess[i] == guess[pos]) {
                return false;
            }
        }
        return true;
    }
}