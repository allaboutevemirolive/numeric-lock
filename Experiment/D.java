package Experiment;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class D {

    private int[] combination = new int[3];

    public boolean[] matchesInPlace(int[] a, int[] b) {
        return Arrays.equals(a, b) ? new boolean[a.length] : IntStream.range(0, a.length).mapToObj(i -> a[i] == b[i]).mapToBoolean(Boolean::booleanValue).toArray(size -> new boolean[size]);
    }
    
    public int numMatchesInPlace(int[] a, int[] b) {
        return (int) IntStream.range(0, a.length).filter(i -> a[i] == b[i]).count();
    }

    public int numDigitsRight(int[] a, int[] b) {
        Set<Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());
        return (int) Arrays.stream(b).filter(setA::contains).count();
    }

    public boolean rule1(int[] guess) {
        return numMatchesInPlace(guess, new int[]{6, 8, 2}) == 1 && numDigitsRight(guess, new int[]{6, 8, 2}) == 1;
    }

    public boolean rule2(int[] guess) {
        return numMatchesInPlace(guess, new int[]{6, 1, 4}) == 0 && numDigitsRight(guess, new int[]{6, 1, 4}) == 1;
    }

    public boolean rule3(int[] guess) {
        return numMatchesInPlace(guess, new int[]{2, 0, 6}) == 0 && numDigitsRight(guess, new int[]{2, 0, 6}) == 2;
    }

    public boolean rule4(int[] guess) {
        return numDigitsRight(guess, new int[]{7, 3, 8}) == 0;
    }

    public boolean rule5(int[] guess) {
        return numMatchesInPlace(guess, new int[]{3, 8, 0}) == 0 && numDigitsRight(guess, new int[]{3, 8, 0}) == 1;
    }

    public void printGuess(int[] guess) {
        System.out.printf("%n%d-%d-%d", guess[0], guess[1], guess[2]);
    }

    public boolean evaluate(int[] guess) {
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
        }
        return false;
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
        return Arrays.stream(guess, 0, pos).noneMatch(i -> i == guess[pos]);
    }
}
