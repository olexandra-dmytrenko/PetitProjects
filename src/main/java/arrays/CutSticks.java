package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Oleksandra_Dmytrenko on 7/22/2017.
 * Дан массив из длин палочек. Каждый раз выбираем самую маленькую и отнимаем ее длину от остальных пока минимальная палочка не привратится в 0.
 *
 */
public class CutSticks {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 3, 3, 2, 1};
        int[] ints = cutSticks(input);
        for (int i1 : ints) {
            System.out.println(i1);
        }
    }

    private static int[] cutSticks(int[] lengths) {
        ArrayList<Integer> cutAmounts = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i : lengths) {
            list.add(i);
        }

        Integer min = Collections.min(list);
        while (min > 0) {
            int numberOfCuts = 0;
            for (int i = 0; i < list.size(); i++) {
                Integer element = list.get(i);
                if (element >= min) {
                    list.set(i, element - min);
                    numberOfCuts++;
                }
            }
            cutAmounts.add(numberOfCuts);
            Iterator i = list.iterator();
            while (i.hasNext()) {
                Integer next = (Integer) i.next();
                if (next == 0) {
                    i.remove();
                }
            }
//            list = list.stream().filter(el -> el != 0).collect(Collectors.toList());
            min = list.size() > 0 ? Collections.min(list) : 0;
        }
        int[] cutAmountsArr = new int[cutAmounts.size()];
        for (int k = 0; k < cutAmounts.size(); k++) {
            cutAmountsArr[k] = cutAmounts.get(k);
        }
        return cutAmountsArr;
    }
}