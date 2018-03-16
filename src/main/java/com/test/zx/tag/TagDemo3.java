package com.test.zx.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Taylor
 */
public class TagDemo3 extends TagSupport {

    private static int x = 3;
    @Override
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
    }

    /* 控制doAfterBody()方法的返回值，
     * 如果这个方法返回EVAL_BODY_AGAIN， 则web服务器又执行一次标签体，
     * 依次类推，一直执行到doAfterBody方法返回SKIP_BODY，则标签体才不会重复执行。
     * @see javax.servlet.jsp.tagext.TagSupport#doAfterBody()
     */
    @Override
    public int doAfterBody() throws JspException {
        x--;
        if(x>0){
            return EVAL_BODY_AGAIN;
        }else{
            return SKIP_BODY;
        }
    }

}
