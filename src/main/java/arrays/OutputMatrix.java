package arrays;

public class OutputMatrix {
    public static void main(String args[]) {
        int size = 5;
        StringBuilder out = new StringBuilder();
        int starIndex = 0;
        int row = 1;
        for (int i = 1; i <= size * size; i++) {
            out.append(i).append(" ");
            if (i % size == 0) {
                System.out.println(out);
                System.out.println();
                out = new StringBuilder();
                row++;
                starIndex = starIndex >= size/2 ? starIndex - 1 : starIndex + 1;
            }
        }
    }
}