package com.test.zx.asert;

/**
 * @author Taylor
 */
public class AssertionTest {

    public static void main(String[] args) {

        boolean isSafe = false;
        assert isSafe : "Not safe at all";
        System.out.println("断言通过!");
    }
}
