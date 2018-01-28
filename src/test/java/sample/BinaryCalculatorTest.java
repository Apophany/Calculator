package sample;

import org.junit.Test;

import static java.lang.Integer.toBinaryString;

public class BinaryCalculatorTest {

    private static int bitMask = 1;

    @Test
    public void add() {
        int x =53;
        int y = 35;

        System.out.println(toBinaryString(53));
        System.out.println(toBinaryString(35));
        System.out.println();

        while (x != 0)
        {
            int c = y & x;
            System.out.println(toBinaryString(c) + " | " + c);

            y = y ^ x;
            x = c << 1;

            System.out.println(toBinaryString(y) + " | " + y);
            System.out.println(toBinaryString(x) + " | " + x);

            System.out.println();
        }
    }

    @Test
    public void subtract() {
    }

    @Test
    public void multiply() {
    }

    @Test
    public void divide() {
    }
}