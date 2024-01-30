package com.ontariotechu.sofe3980U;

// import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest {
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor() {
        Binary binary = new Binary("1001001");
        assertTrue(binary.getValue().equals("1001001"));
    }

    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits() {
        Binary binary = new Binary("1001001211");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars() {
        Binary binary = new Binary("1001001A");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign() {
        Binary binary = new Binary("-1001001");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * T est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing() {
        Binary binary = new Binary("00001001");
        assertTrue(binary.getValue().equals("1001"));
    }

    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString() {
        Binary binary = new Binary("");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add() {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("10111"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first
     * argument is less than the second
     */
    @Test
    public void add2() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first
     * argument is greater than the second
     */
    @Test
    public void add3() {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test The add functions with two zeros
     */
    @Test
    public void add5() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    /**
     * Test The or functions with two binary numbers of different length
     */
    @Test
    public void orTest1() {
        Binary num1 = new Binary("10101001");
        Binary num2 = new Binary("111010");

        Binary resultOr = Binary.or(num1, num2);
        assertEquals("10111011", resultOr.getValue());
    }

    /**
     * Test the or function with two binary numbers with only 1s
     */
    @Test
    public void orTest2() {
        Binary num1 = new Binary("11111111");
        Binary num2 = new Binary("11111111");

        Binary resultOr = Binary.or(num1, num2);
        assertEquals("11111111", resultOr.getValue());
    }

    /**
     * Test the or function with two binary numbers of very different lengths
     */
    @Test
    public void orTest3() {
        Binary num1 = new Binary("11111111");
        Binary num2 = new Binary("01");

        Binary resultOr = Binary.or(num1, num2);
        assertEquals("11111111", resultOr.getValue());
    }

    /**
     * Test the or function with two binary numbers of very different lengths
     */
    @Test
    public void orTest4() {
        Binary num1 = new Binary("0");
        Binary num2 = new Binary("0");

        Binary resultOr = Binary.or(num1, num2);
        assertEquals("0", resultOr.getValue());
    }

    /**
     * Test The and functions with two binary numbers of different length
     */
    @Test
    public void andTest1() {
        Binary num1 = new Binary("10001000");
        Binary num2 = new Binary("111000");

        Binary resultAnd = Binary.and(num1, num2);
        assertEquals("1000", resultAnd.getValue());
    }

    /**
     * Test The and functions with two binary numbers of the same length
     */
    @Test
    public void andTest2() {
        Binary num1 = new Binary("1000010");
        Binary num2 = new Binary("0010100");

        Binary resultAnd = Binary.and(num1, num2);
        assertEquals("0", resultAnd.getValue());
    }

    /**
     * Test The and functions with two binary numbers of the same length
     */
    @Test
    public void andTest3() {
        Binary num1 = new Binary("11");
        Binary num2 = new Binary("011");

        Binary resultAnd = Binary.and(num1, num2);
        assertEquals("11", resultAnd.getValue());
    }

    /**
     * Test The multiply functions with two binary numbers of the same length
     */
    @Test
    public void multiplyTest1() {
        Binary num1 = new Binary("10001000");
        Binary num2 = new Binary("111000");

        Binary resultMultiply = Binary.multiply(num1, num2);
        assertEquals("1110111000000", resultMultiply.getValue());
    }

    /**
     * Test The multiply functions with two binary numbers of the same length
     */
    @Test
    public void multiplyTest2() {
        Binary num1 = new Binary("1010101");
        Binary num2 = new Binary("0011001");

        Binary resultMultiply = Binary.multiply(num1, num2);
        assertEquals("100001001101", resultMultiply.getValue());
    }

    /**
     * Test The multiply functions with two binary numbers of the same length
     */
    @Test
    public void multiplyTest3() {
        Binary num1 = new Binary("1010101001");
        Binary num2 = new Binary("001100100001");

        Binary resultMultiply = Binary.multiply(num1, num2);
        assertEquals("10000101001011001001", resultMultiply.getValue());
    }
}