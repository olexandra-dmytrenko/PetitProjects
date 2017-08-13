package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oleksandra_Dmytrenko on 8/13/2017.
 */
public class IfAnagrams {
    private static HashMap<Character, Integer> lettersAmount = new HashMap<>(26);

    static {
        lettersAmount.put('a', 0);
        lettersAmount.put('b', 0);
        lettersAmount.put('c', 0);
        lettersAmount.put('d', 0);
        lettersAmount.put('e', 0);
        lettersAmount.put('f', 0);
        lettersAmount.put('g', 0);
        lettersAmount.put('h', 0);
        lettersAmount.put('i', 0);
        lettersAmount.put('j', 0);
        lettersAmount.put('k', 0);
        lettersAmount.put('l', 0);
        lettersAmount.put('m', 0);
        lettersAmount.put('n', 0);
        lettersAmount.put('o', 0);
        lettersAmount.put('p', 0);
        lettersAmount.put('q', 0);
        lettersAmount.put('r', 0);
        lettersAmount.put('s', 0);
        lettersAmount.put('t', 0);
        lettersAmount.put('u', 0);
        lettersAmount.put('v', 0);
        lettersAmount.put('w', 0);
        lettersAmount.put('x', 0);
        lettersAmount.put('y', 0);
        lettersAmount.put('z', 0);
    }

    static int[] getMinimumDifference(String[] a, String[] b) {
        int length = a.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            String first = a[i];
            String second = b[i];
            if (first.length() != second.length()) {
                result[i] = -1;
            } else {
                HashMap<Character, Integer> firstSymbolsAmountMap = createSymbolsAmountMap(first);
                HashMap<Character, Integer> secondSymbolsAmountMap = createSymbolsAmountMap(second);
                if (firstSymbolsAmountMap.equals(secondSymbolsAmountMap)) {
                    result[i] = 0;
                } else {
                    int countDifs = 0;
                    for (Map.Entry<Character, Integer> firstEntry : firstSymbolsAmountMap.entrySet()) {
                        Integer secondAmount = secondSymbolsAmountMap.get(firstEntry.getKey());
                        int symbolsAmountDif = firstEntry.getValue() - secondAmount;
                        if (symbolsAmountDif > 0) {
                            countDifs += symbolsAmountDif;
                        }
                    }
                    result[i] = countDifs;
                }
            }
        }
        return result;
    }

    private static HashMap<Character, Integer> createSymbolsAmountMap(String string) {
        HashMap<Character, Integer> lettersAmountMap = new HashMap<>(lettersAmount);
        for (int j = 0; j < string.length(); j++) {
            Character ch = string.charAt(j);
            lettersAmountMap.put(ch, lettersAmountMap.get(ch) + 1);
        }
        return lettersAmountMap;
    }

    public static void main(String[] args) {
        String[] a = {"gcc"};
        String[] b = {"bba"};
        int[] minimumDifference = getMinimumDifference(a, b);
        for (int i = 0; i < minimumDifference.length; i++) {
            int i1 = minimumDifference[i];
            System.out.println(i1);
        }
    }
}
