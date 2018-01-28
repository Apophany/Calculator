package sample;

/**
 * Calculator to perform basic
 * integer operations using bitwise
 * operators only.
 */
public class BinaryCalculator implements Calculator {

    /**
     * O(n) algorithm
     */
    @Override
    public int add(int x, int y) {
        while (y != 0) {
            int carry = x & y; //Find the bits to carry
            x =  x ^ y; //Sum ignoring carry
            y = carry << 1; //Shift the carry bits to the right position
        }
        return x;
    }

    /**
     * O(n) algorithm
     */
    @Override
    public int subtract(int x, int y) {
        return add(x, negate(y));
    }

    /**
     * Implements the following rule:
     * x * y =
     *   2*(x*(y/2)) | y is even
     *   x + 2*(x*(y/2)) | y is odd
     *
     *  O(n^2) algorithm
     */
    @Override
    public int multiply(int x, int y) {
        if (y == 0) {
            return 0;
        }

        //x * (2/y)
        int z = multiply(x, y >> 1);

        //If even
        if ((y & 1) == 0) {
            // 2*z
            return z << 1;
        }
        //x + 2*z
        return add(x, z << 1);
    }

    /**
     * O(n^2) algorithm
     */
    @Override
    public int divide(int x, int y) {
        int result = 0;
        if (y != 0) {
            while (x >= y) {
                x = subtract(x, y);
                result = add(result, 1);
            }
        }
        return result;
    }

    //Ones compliment + 1 = twos complement
    private int negate(int x) {
        return add(~x, 1);
    }

    public static void main(String[] args) {
        System.out.println(new BinaryCalculator().divide(10, 2));
    }
}
