package algorithms.recursion;

/**
 * Created by olexandra on 8/27/17.
 */
public class Recursion {
    public static void main(String[] args) {
        String result = solve("MORE_ACTIONS_ARE_NEEDED");
        System.out.println(result);
    }

    private static String solve(String conditionWhichMayNotBeObvious) {
        System.out.println(conditionWhichMayNotBeObvious);
        switch (conditionWhichMayNotBeObvious) {
            case "MORE_ACTIONS_ARE_NEEDED":
                // тут вы высчитываете следующий входной результат в этот же метод
                return solve("SOME_NEW_CONDITIONS");
            default:
                return "THE_END_OF_RECURSION";
        }
    }


    private static String solve(int index) {
        if (index > 1) {
            solve(index--, "Having hard time with a big index");
        } else if (index == 1) {
            solve(index, "We're almost there");
        } else {
            return "This is the end.";
        }
        return null;
    }

    private static int solve(int index, String output) {
        System.out.println(output + " Index: " + index);
        solve(--index);
        return index;
    }
}