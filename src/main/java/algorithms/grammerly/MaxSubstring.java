package algorithms.grammerly;

public class MaxSubstring {

    public static void main(String[] args) {
        String s = "baca";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < args.length; j++) {
                String sub = s.substring(i, j);
                System.out.println(sub);
            }
        }
    }


}
