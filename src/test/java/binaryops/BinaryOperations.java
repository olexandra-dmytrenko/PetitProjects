package binaryops;

import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class BinaryOperations {

    @Test
    public void soutsForCheck() {
        System.out.println("" + Integer.toBinaryString(8 >>> 1 | 1));
        System.out.println("" + Integer.toBinaryString(8 << 1 | 8 >>> 1));
        System.out.println("" + Integer.toBinaryString(8 >>> 1));
        System.out.println("" + Integer.toBinaryString(8 >>> 3));
        System.out.println("bits3=" + Integer.toBinaryString(0b00100000_00000000_00000000_00000000 >>> 30));
        System.out.println("bits3`=" + Integer.toBinaryString(0b00100000_00000000_00000000_00000000 >> 30));
        System.out.println("bits3`=" + Integer.toBinaryString(0b00100000_00000000_00000000_00000000 >> 27));
        System.out.println("bits3=" + Integer.toBinaryString(0b01000000_00000000_00000000_00000000 >>> 30));
        System.out.println("bits3`=" + Integer.toBinaryString(0b01000000_00000000_00000000_00000000 >> 30));
        System.out.println("bits3=" + Integer.toBinaryString(0b10000000_00000000_00000000_00000000 >>> 30));
        System.out.println("bits3`=" + Integer.toBinaryString(0b10000000_00000000_00000000_00000000 >> 30));
        System.out.println("bits3=" + Integer.toBinaryString(0b10000000_00000000_00000000_00000000 >>> 31));
        System.out.println("bits3`=" + Integer.toBinaryString(0b10000000_00000000_00000000_00000000 >> 31));
        System.out.println("bits3=" + Integer.toBinaryString(0b10000000_00000000_00000000_00000000 >>> 1));
        System.out.println("bits3`=" + Integer.toBinaryString(0b10000000_00000000_00000000_00000000 >> 1));
        System.out.println("bits3`=" + Integer.toBinaryString(0b10000000_00000000_00000000_00000000 << 1));
        System.out.println("bits3`=" + Integer.toBinaryString(0b10000000_00000000_00000000_00000000 << 20));
        System.out.println("int Size=" + Integer.toBinaryString(Integer.SIZE));

    }

    @Test
    public void leftShiftingBeginning() {
        int actual = IntegerUtils.leftShift(0b10000000_00000000_00000000_00000000);
        assertEquals(actual, 0b00000000_00000000_00000000_00000001);
    }

    @Test
    public void leftShiftingMiddle() {
        int actual = IntegerUtils.leftShift(0b00000001_00000000_00000000_00000000);
        assertEquals(actual, 0b00000010_00000000_00000000_00000000);
    }

    @Test
    public void leftShiftingEnd() {
        int actual = IntegerUtils.leftShift(0b00000000_00000000_00000000_00000001);
        assertEquals(actual, 0b00000000_00000000_00000000_00000010);
    }

    public static class IntegerUtils {
        public static int leftShift(int bits) {
            int k = 1;
            int i = bits << k;
            int j = bits >>> (Integer.SIZE - k);
            int result = bits << k | bits >>> (Integer.SIZE - k);
            System.out.println("bits1=" + Integer.toBinaryString(bits));
            System.out.println("bits2=" + Integer.toBinaryString(i));
            System.out.println("bits3=" + Integer.toBinaryString(j));
            System.out.println("bits4=" + Integer.toBinaryString(result));
//            int result = arg << 1;
//            int x = 0b10000000_00000000_00000000_00000000;
//
//            if (x == (x & arg)) {
//                result += 1;
//            }

            return result;
        }
    }
}
