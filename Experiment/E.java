package Experiment;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.IntStream;

// succeeded
public class E {

    private int[] combination = new int[3];

    public boolean[] matchesInPlace(int[] a, int[] b) {
        boolean[] result = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] == b[i];
        }
        return result;
    }

    public int numMatchesInPlace(int[] a, int[] b) {
        return (int) IntStream.range(0, a.length).filter(i -> a[i] == b[i]).count();
    }

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
        return numMatchesInPlace(guess, new int[] { 6, 8, 2 }) == 1 && numDigitsRight(guess, new int[] { 6, 8, 2 }) == 1;
    }

    public boolean rule2(int[] guess) {
        return numMatchesInPlace(guess, new int[] { 6, 1, 4 }) == 0 && numDigitsRight(guess, new int[] { 6, 1, 4 }) == 1;
    }

    public boolean rule3(int[] guess) {
        return numMatchesInPlace(guess, new int[] { 2, 0, 6 }) == 0 && numDigitsRight(guess, new int[] { 2, 0, 6 }) == 2;
    }

    public boolean rule4(int[] guess) {
        return numDigitsRight(guess, new int[] { 7, 3, 8 }) == 0;
    }

    public boolean rule5(int[] guess) {
        return numMatchesInPlace(guess, new int[] { 3, 8, 0 }) == 0 && numDigitsRight(guess, new int[] { 3, 8, 0 }) == 1;
    }

    public void printGuess(int[] guess) {
        System.out.print("\n" + guess[0] + "-" + guess[1] + "-" + guess[2]);
    }

    public boolean evaluate(int[] guess) {
        printGuess(guess);
        System.out.print(":");
        int fails = (int) IntStream.rangeClosed(1, 5).filter(i -> !Objects.requireNonNullElseGet(
                switch (i) {
                    case 1 -> rule1(guess);
                    case 2 -> rule2(guess);
                    case 3 -> rule3(guess);
                    case 4 -> rule4(guess);
                    case 5 -> rule5(guess);
                    default -> false;
                }, () -> false)).count();
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
        return IntStream.range(0, pos).allMatch(i -> guess[i] != guess[pos]);
    }
}
