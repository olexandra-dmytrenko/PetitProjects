package ekids;

public class AiBAnswer {

    private static final String[] firstList = {
            "А і Б",
            "А впало, ",
            "Хто залишився? "
    };
    private static final String[] secondList = {
            "Сиділи на трубі.",
            "Б пропало. ",
            "Скажи :)"
    };

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(firstList[i]);
            System.out.println(secondList[i]);
        }
    }
}