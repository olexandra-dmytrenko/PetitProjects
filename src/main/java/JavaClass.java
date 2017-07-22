/**
 * Created by Oleksandra_Dmytrenko on 3/14/2017.
 */
public class JavaClass {

    public static void main(String[] args) {
        int number = 5;
        String a =
                number % 2 == 0
                        ? "Div by 2"
                        : (number % 3 == 0)
                        ? "Div by 3"
                        : "No div";
        System.out.println(a);
    }
}