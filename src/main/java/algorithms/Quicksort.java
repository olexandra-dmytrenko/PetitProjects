package algorithms;

/**
 * Created by olexandra on 6/27/17.
 */
public class Quicksort  {
    private int[] numbers;
    private int number;

    public int[] sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            throw new IndexOutOfBoundsException("Give normal array");
        }
        this.numbers = values;
        number = values.length;

        quicksort(0, number - 1);
        return numbers;
//        return new SortArrays().quickSort(numbers);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two listsswhile (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        Quicksort q = new Quicksort();
        int [] a = {5, 4, 1,2, 3, -1, 4, 2, 6};
        q.sort(a);
    }
}