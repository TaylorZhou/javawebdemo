package com.test.zx.fanxing;

/**
 * @author Taylor
 * @version 1.0
 */
public class TupleTest {
    static TwoTuple<String, Integer> f(){
        return Tuple.tuple("HI",22);
    }
    static TwoTuple f2(){
        return Tuple.tuple("HI",22);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi;

        ttsi = (TwoTuple<String, Integer>)f2();
    }
}
