package com.test.zx.lombok;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.Wither;

/**
 * @author Taylor
 * @version 1.0
 */
public class WitherExample {

    @Wither
    private final String age;
    @Wither(AccessLevel.PROTECTED) @NonNull
    private final String name;

    public WitherExample(String name, String age) {
        if (name == null) throw new NullPointerException();
        this.name = name;
        this.age = age;
    }


}
