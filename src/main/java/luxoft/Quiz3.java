package luxoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olexandra on 11/5/17.
 */
public class Quiz3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        for(String nullString:list){
            list.remove(0);
        }
        //returns 1
        System.out.println(list.size());
    }
}