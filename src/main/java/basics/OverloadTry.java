package basics;

import java.text.ParseException;

import lombok.ToString;

@ToString
public class OverloadTry {
    static final int CONST = 1;
    Character a = '3';
    int c = 1;
 /*   private int b = 2;
//    protected static double c = 3;
    */

    public static void main(String[] args) throws ParseException {
        OverloadTry a = new OverloadTry();
        System.out.println(a.toString());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj == this) {
            result = true;
        } else {
            if (obj.hashCode() == this.hashCode()) {
                OverloadTry other = (OverloadTry) obj;
                result = this.CONST == other.CONST && this.a.equals(other.a);
                //compare objects
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(a);
    }
}
