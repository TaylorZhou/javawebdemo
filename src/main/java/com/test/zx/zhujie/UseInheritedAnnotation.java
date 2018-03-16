package com.test.zx.zhujie;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/**
 * @author Taylor
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Inheritable{

}

@interface UnInheritable{

}

public class UseInheritedAnnotation{
    @UnInheritable
    @Inheritable
    public static class Super{

    }

    public static class Sub extends  Super {

    }

    public static void main(String... args){

        Super instance=new Sub();
        //result : [@com.walidake.annotation.util.Inheritable()]
        System.out.println(Arrays.toString(instance.getClass().getDeclaredAnnotations()));
    }
}

