package com.test.zx.zhujie.annotations;

/**
 * @author Taylor
 * @version 1.0
 */
public class Man {
    @Interface("ManInterface")
    public void eat() {
        System.out.println("Eat");
    }

    public static void main(String[] args) {
        new Man().eat();
    }
}
