package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nykyta on 6/25/2017.
 */
public class NykytaSortNumbers {
    //variables
    private ArrayList<Double> listOfNumbers = new ArrayList<Double>(Arrays.asList(-5.0, 4.0, 3.0, 9.0, 1.0, 0.0, -25.0));
    private ArrayList<Double> listOfSortedNumbers = new ArrayList<>();
    private boolean sortInReverseOrder = true;
    private StringBuilder listOfSortedNumberListInTextFormat = new StringBuilder();

    public void nykytaSortAndPrint() {
        int iterationsCount = 0;
        while (listOfNumbers.size() != 0) {
            double minimumOrMaximum = listOfNumbers.get(0);
            int searchedOverElementsNumber = 0;
            for (int count = 0; count < listOfNumbers.size(); count++) {
                if (sortInReverseOrder == false) {
                    if (listOfNumbers.get(count) < minimumOrMaximum) {
                        minimumOrMaximum = listOfNumbers.get(count);
                    }
                }
                if (sortInReverseOrder == true) {
                    if (listOfNumbers.get(count) > minimumOrMaximum) {
                        minimumOrMaximum = listOfNumbers.get(count);
                    }
                }
                ++searchedOverElementsNumber;
            }
            System.out.println("Iteration number " + ++iterationsCount + ".\n Searched over " + searchedOverElementsNumber);
            listOfSortedNumbers.add(minimumOrMaximum);
            listOfNumbers.remove(minimumOrMaximum);
        }

         outputArray();
        System.out.println(listOfSortedNumberListInTextFormat);
    }

    public void bubbleSortAndPrint() {
        for (int i = listOfNumbers.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (listOfNumbers.get(j) > listOfNumbers.get(j + 1)) {
                    double tmp = listOfNumbers.get(j);
                    listOfNumbers.set(j, listOfNumbers.get(j + 1));
                    listOfNumbers.set(j + 1, tmp);
                }
            }
        }
        listOfSortedNumbers = listOfNumbers;
        listOfSortedNumberListInTextFormat.append("The list of sorted numbers is:");

        outputArray();
        System.out.println(listOfSortedNumberListInTextFormat);
    }

    public void insertSortAndPrint() {
        int j;
        double temp;
        for (int i = 0; i < listOfNumbers.size() - 1; i++) {
            if (listOfNumbers.get(i) > listOfNumbers.get(i + 1)) {
                temp = listOfNumbers.get(i + 1);
                listOfNumbers.set(i + 1, listOfNumbers.get(i));
                j = i;
                while (j > 0 && temp < listOfNumbers.get(j - 1)) {
                    listOfNumbers.set(j, listOfNumbers.get(j - 1));
                    j--;
                }
                listOfNumbers.set(j, temp);
            }
        }
        listOfSortedNumbers = listOfNumbers;
        listOfSortedNumberListInTextFormat.append("The list of sorted numbers is:");
        outputArray();
        System.out.println(listOfSortedNumberListInTextFormat);
    }

    private void outputArray() {
        listOfSortedNumberListInTextFormat.append("The list of sorted numbers is:");
        for (double d : listOfSortedNumbers) {
            listOfSortedNumberListInTextFormat.append(d + ",");
        }
    }
}
