package algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by olexandra on 6/25/17.
 */
public class SortArrays {
    private static int allIterations = 0;
    private int[] arr;

    public static List<Integer> bubbleSort(List<Integer> list) {
        for (int j = 0; j < list.size() - 1; j++) {
            System.out.println("General iteration number " + j);
            flipElements(list);
        }
        return list;
    }

    private static void flipElements(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(++allIterations + " Local iteration");
            if (list.get(i) > list.get(i + 1)) {
                int temp = list.get(i);
                list.set(i, list.get(i + 1));
                list.set(i + 1, temp);
            }
        }
    }

    public static LinkedList<Integer> sortByInsertions(LinkedList<Integer> list) {
        int iterationNumber = 0;
        for (int i = 1; i < list.size(); i++) {
            System.out.println("Take next number " + list.get(i) + " to place it in the right place.");
            for (int j = 0; j < i; j++) {
                System.out.println(++iterationNumber + " Amount of sorted elements:  " + (i - 1));
                if (list.get(i) < list.get(j)) {
                    list.add(j, list.get(i));
                    list.remove(i + 1);
                    break;
                }
            }
        }
        return list;
    }

    public int[] quickSort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            throw new IndexOutOfBoundsException("Give normal array");
        }
        this.arr = values;
//        number = values.length;
//как опорный возьмем элемент по золотому сечению
        quicksort(0, arr.length - 1);
        return arr;
    }

    private void quickSort(int low, int high) {
        int i = low, j = high;
        //разделим массив на левую часть, где будут элементы меньше опорного и правую, где они будут больше
        int pivot = arr[low + (high - low) / 2];
        while (i <= j) {
            //идем вверх до сталкновения с элементом, большим чем опорный
            while (arr[i] < pivot) {
                i++;
            }
            //идем вниз до сталкновения с элементом, меньшим чем опорный
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(low, j);
        if (high > i)
            quickSort(i, high);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = arr[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (arr[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (arr[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i < j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (high > i)
            quicksort(i, high);
    }

    private void swap(int start, int stop) {
        int temp = arr[start];
        arr[start] = arr[stop];
        arr[stop] = temp;
    }
}
