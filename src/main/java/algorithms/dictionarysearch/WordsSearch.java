package algorithms.dictionarysearch;

import java.util.HashMap;

public class WordsSearch {

    private HashMap<Character, TreeEntity> dict = new HashMap<>();

    public static void main(String[] args) {
    }


    /*public void addToDict(String word) {
        HashMap<Character, TreeEntity> curMap = dict;
        dict.get()
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            TreeEntity newEnt = curMap.get(key);
            if (newEnt.isEmpty()){
                curMap.put()
            }
            if (curMap.next.get(key)

        }
    }*/


    private HashMap<Character, TreeEntity> nextHasMap(char key, HashMap<Character, TreeEntity> curMap) {
        TreeEntity nextEnt = curMap.get(key);
        if (nextEnt.next.isEmpty()) {
            curMap.put(key, new TreeEntity());
        }
        return nextEnt.next;
    }


    private class TreeEntity {
        //private char c;
        private HashMap<Character, TreeEntity> next = new HashMap<>();

        private boolean isEmpty() {
            return next.isEmpty();
        }
    }
}
