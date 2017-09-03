package algorithms.recursion;

/**
 * Created by olexandra on 8/29/17.
 */
public class BinarySearch {
    /**
     * ищем индекс элемента в массиве
     * или возвращаем -1, если элемента нету
     */
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 12, 15, 19}; // где ищем
        int x = 8; // что ищем
        int i  = linearSearch(arr, x);
//        int i = binarySearch(arr, x, 0, arr.length - 1);
        System.out.println(i);
    }

    public static int linearSearch(int[] arr, int x){
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (element == x){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int x, int low, int high) {
        if (high < low) {
            return -1; //не найдено
        }
        int mid = (low + high) / 2;
        if (arr[mid] > x) {
            //ищем в нижней части массива
            return binarySearch(arr, x, low, mid - 1);
        } else if (arr[mid] < x) {
            //ищем в верхней части массива
            return binarySearch(arr, x, mid + 1, high);
        } else return mid; //найденный элемент
    }
}
