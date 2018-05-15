package com.test.zx.fanxing;

/**
 * @author Taylor
 * @version 1.0
 */
public class TwoTuple<A, B> {

    public final A first;
    public final B second;
    public TwoTuple(A a, B b){
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
