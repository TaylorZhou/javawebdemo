package com.test.zx.fanxing;

/**
 * @author Taylor
 * @version 1.0
 */
public class Tuple {

    public static <A, B> TwoTuple<A, B> tuple(A a, B b){
        return new TwoTuple<>(a,b);
    }
}
