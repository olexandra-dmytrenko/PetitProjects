package ekids;

public class AiBQuestion {

    private static final String[] firstList = {
            "А і Б\n",
            "А впало, \n",
            "Хто залишився? "
    };
    private static final String[] secondList = {
            "Сиділи на трубі.\n",
            "Б пропало. \n",
            "Скажи :)"
    };

    public static void main(String[] args) {
        System.out.println("Додай виведення другого масиву, \n" +
                "щоб можна було читати по черзі: \n" +
                "одну строчку з першого масиву, і одну з другого.\n");
        for (int i = 0; i < 3; i++) {
            System.out.println(firstList[i]);
        }
    }
}