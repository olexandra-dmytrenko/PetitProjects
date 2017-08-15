package algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Oleksandra_Dmytrenko on 8/15/2017.
 */
public class MakeAnagrams {

    public static int numberNeeded1(String first, String second) {
        int[] lettercounts = new int[26];
        for (char c : first.toCharArray()) {
            lettercounts[c - 'a']++;
        }
        for (char c : second.toCharArray()) {
            lettercounts[c - 'a']--;
        }
        int result = 0;
        for (int i : lettercounts) {
            result += Math.abs(i);
        }
        return result;
    }

    public static int numberNeeded(String first, String second) {
        int counterToReplace = 0;
        if (first == null || null == second) {
            return 0;
        } else {
            char[] firstChars = first.toCharArray();
            char[] secondChars = second.toCharArray();
            if (firstChars.length > secondChars.length) {
                char[] temp = firstChars;
                firstChars = secondChars;
                secondChars = temp;
            }
            Arrays.sort(firstChars);
            Arrays.sort(secondChars);
            int i = firstChars.length - 1, j = secondChars.length - 1;
            while (i >= 0 && j >= 0) {
                char firstChar = firstChars[i];
                char secondChar = secondChars[j];
                if (firstChar == secondChar) {
                    i--;
                    j--;
                    continue;
                }
                if (firstChar > secondChar) {
                    i--;
                    counterToReplace++;
                } else {
                    j--;
                    counterToReplace++;
                }
            }
            if (i != j) {
                counterToReplace += Math.abs(i - j);
            }
        }
        return counterToReplace;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String a = in.next();
//        String b = in.next();
        String a = "abcv";
        String b = "cde";
        System.out.println(numberNeeded1(a, b));
    }
}
