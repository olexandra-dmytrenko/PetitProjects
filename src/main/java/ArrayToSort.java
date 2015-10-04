/**
 * Created by olexandra on 27.09.15.
 * Answers the question if array can be sorted in one replacement or less.
 */
public class ArrayToSort {
    int[] arr;

    public ArrayToSort(int[] arr) {
        this.arr = arr;
    }

    public boolean canBeSorted() {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array should have values");
        }
        if (arr.length > 2) {
            int arg1 = getUnorfderedElementIndex(0, arr.length - 2, -1);
            if (arg1 != -1 && arg1 <= arr.length - 2) {
                int arg2 = getUnorfderedElementIndex(arg1 + 1, arr.length - 2, arg1);
                if (arg1 != -1) {
                    if (arr[arg2] <= arr[arg1 + 1] && arr[arg2 - 1] <= arr[arg1]) {//check middle exchange
                        if (arg1 != 0 && arr[arg1 - 1] <= arr[arg2]) {
                            if (arg2 != arr.length - 1 && arr[arg1] <= arr[arg2 + 1]) {
                                return checkLast(arg2);
                            } else return true;
                        } else if (arg2 != arr.length - 1 && arr[arg1] <= arr[arg2 + 1]) {
                            return checkLast(arg2);
                        } else return false;
                    } else return false;
                }
            }
            return true; // array is sorted
        }
        return true;
    }

    private boolean checkLast(int arg2) {
        if (arg2 + 1 <= arr.length - 2) {
            int argLast = getUnorfderedElementIndex(arg2 + 1, arr.length - 2, -1);
            if (argLast == -1) {
                return true;
            }
            return false;
        }
        return true;
    }

    private int getUnorfderedElementIndex(int start, int end, int prev) {
        for (int i = start; i <= end; i++) {
            if (arr[i] > arr[i + 1]) {
                if ((prev != -1 && arr[i + 1] >= arr[prev])
                        || prev == -1) {
                    return i;
                } else {
                    return i + 1;
                }
            }
            if (prev != -1 && arr[i] >= arr[prev]) {
                return i - 1;
            }
        }
        if (prev != -1) {
            if (arr[end + 1] < arr[prev]) {
                return end + 1;
            }
            if (arr[end + 1] >= arr[prev]) {
                return end;
            }
        }
        return -1;
    }
    //{1, 3, 2}
}
