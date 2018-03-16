package com.test.zx.zhujie;

import java.lang.annotation.Documented;

/**
 * @author Taylor
 */
@Documented
@interface DocumentedAnnotation {
}

@interface UnDocumentedAnnotation {

}

@DocumentedAnnotation
@UnDocumentedAnnotation
public class Demo {

    public static void main(String[] args) throws Exception {
        System.out.println("android.widget.TextView tv = 2131427422");

    }
}
