package com.test.zx.fanxing;

/**
 * @author Taylor
 * @version 1.0
 */

class Generic<T>{
}
public class ArrayOfGeneric {
    static final int SIZE = 100;

    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        gia = (Generic<Integer>[])new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();
        //gia[1] = (Generic<Integer>)new Object();
        /*gia[2] = new Generic<Double>();*/
    }

}
