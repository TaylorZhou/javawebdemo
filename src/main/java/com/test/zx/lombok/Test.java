package com.test.zx.lombok;

/**
 * @author Taylor
 */
public class Test {

    public static void main(String[] args) {
        User user = new User();
        user.setUserId("1");
        user.getGroups().add("111");
        System.out.println(user);
    }
}
