package algorithms;

import java.util.*;

/**
 * Created by olexandra on 6/27/17.
 */
public class FinanceIncomeFromGoogle {

    TreeMap<String, FinanceStats> data = new TreeMap<String, FinanceStats>();

    public static void main(String[] args) {
        Queue q = new LinkedList();
        Stack s = new Stack();
        Map m = new TreeMap<Object, Object>();
        //    TreeMap m1 = new TreeMap(Compa)
    }

    public void receiveData(String time, int val) {
//new entry
        if (val != 0 && data.containsKey(time)) {
            data.put(time, new FinanceStats(data.lastEntry().getValue(), val));
        } else if (val == 0) {//add that it can be update
            FinanceStats statsToDel = data.get(val);
            if (statsToDel.cur == statsToDel.max || statsToDel.cur == statsToDel.min) {
                //spread the error fix data on future
                Map.Entry<String, FinanceStats> lastCorrect = data.floorEntry(time);
                String startKey = time;
                while (data.ceilingEntry(startKey).getValue().cur != val
                        && (data.ceilingEntry(startKey).getValue().min == val)
                        || data.ceilingEntry(startKey).getValue().max == val){
                    data.ceilingEntry(startKey).getValue().min = lastCorrect.getValue().min;//if to update min
                    data.ceilingEntry(startKey).getValue().max = lastCorrect.getValue().max;//if to update max
                }
             //fix future data
            } data.remove(time);
        }

    }

    private static class FinanceStats {
        private int min;
        private int max;
        private int cur;


        FinanceStats(FinanceStats previousStats, int newVal) {
            countNew(previousStats, newVal);
        }


        static FinanceStats countNew(FinanceStats previousStats, int newVal) {
            final int newMax = previousStats.max > newVal
                    ? previousStats.max
                    : newVal;
            final int newMin = previousStats.min < newVal
                    ? previousStats.min
                    : newVal;
            return new FinanceStats(newMin, newMax, newVal);
        }

        FinanceStats(int min, int max, int cur) {
            this.min = min;
            this.max = max;
            this.cur = cur;
        }
    }

}
