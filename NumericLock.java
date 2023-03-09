import java.util.ArrayList;

public class NumericLock {

    // Returns the number of elements in guess that are in the same position as the corresponding element in target
    public int countMatchesInPlace(int[] guess, int[] target) {
        int count = 0;
        boolean[] matches = new boolean[guess.length];
        // ex. [1,2,3], [3,2,1] => [false, true, false]
        for (int i = 0; i < guess.length; i++) {
            matches[i] = (guess[i] == target[i]);
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
    public int countDigitsIntersection(int[] guess, int[] target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : guess) {
            list.add(num);
        }
        int count = 0;
        for (int num : target) {
            if (list.contains(num)) {
                count++;
                list.remove(Integer.valueOf(num));
            }
        }
        return count;
    }

    public boolean hasOneDigitRightAndInPlace(int[] guess) {
        int[] target = { 6, 8, 2 };
        return (countMatchesInPlace(guess, target) == 1) && (countDigitsIntersection(guess, target) == 1);
    }

    public boolean hasOneDigitRightButInWrongPlace(int[] guess) {
        int[] target = { 6, 1, 4 };
        return (countMatchesInPlace(guess, target) == 0) && (countDigitsIntersection(guess, target) == 1);
    }

    public boolean hasTwoDigitsRightButInWrongPlace(int[] guess) {
        int[] target = { 2, 0, 6 };
        return (countMatchesInPlace(guess, target) == 0) && (countDigitsIntersection(guess, target) == 2);
    }

    public boolean hasNoDigitRight(int[] guess) {
        int[] target = { 7, 3, 8 };
        return (countDigitsIntersection(guess, target) == 0);
    }

    public boolean hasOneDigitRightButInWrongPlace2(int[] guess) {
        int[] target = { 3, 8, 0 };
        return (countMatchesInPlace(guess, target) == 0) && (countDigitsIntersection(guess, target) == 1);
    }

    public boolean evaluate(int[] guess) {
        // Print the guess in the format 'a-b-c'
        System.out.print("\n" + guess[0] + "-" + guess[1] + "-" + guess[2]);
        System.out.print(":");
        int fails = 0;
        if (!hasOneDigitRightAndInPlace(guess)) {
            System.out.print(" !r1");
            fails++;
        }
        if (!hasOneDigitRightButInWrongPlace(guess)) {
            System.out.print(" !r2");
            fails++;
        }
        if (!hasTwoDigitsRightButInWrongPlace(guess)) {
            System.out.print(" !r3");
            fails++;
        }
        if (!hasNoDigitRight(guess)) {
            System.out.print(" !r4");
            fails++;
        }
        if (!hasOneDigitRightButInWrongPlace2(guess)) {
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