package testingGoIT6;

/**
 * Created by olexandra on 11.10.15.
 */

import java.util.Arrays;

/**
 * Created by L. Hupalo on 9/28/15.
 */
public class OneSwipeArray {
    public OneSwipeArray(int[] array) {
        this.arrayToCheck = array;
    }

    public int[] arrayToCheck;

    public boolean solution() {

        if (arrayToCheck == null) {
            throw new IllegalArgumentException();
        }
        if (arrayToCheck.length < 2) {
            throw new IllegalArgumentException();
        }

        return checkArray(arrayToCheck);
    }

    private boolean checkArray(int[] arrayToCheck) {

        int[] arrayCopy = arrayToCheck.clone();
        Arrays.sort(arrayCopy);
        int count = 0;
        for (int i = 0; i < arrayCopy.length; i++) {
            if (arrayToCheck[i] != arrayCopy[i]) {
                count++;
                if (count > 2) return false;
            }
        }
        if (count == 2) return true;
        return false;
    }
}