package com.test.zx.fanshe;

/**
 * @author Taylor
 */
public class Pair<T> {
    T obj;

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getT(){
        Object obj = new Object();
        return (T)obj;
    }

    public static <T> T show(T one){//这是正确的

        return one;
    }
}
