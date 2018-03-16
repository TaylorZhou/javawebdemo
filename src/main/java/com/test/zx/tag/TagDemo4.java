package com.test.zx.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * @author Taylor
 */
public class TagDemo4 extends BodyTagSupport {

    /* 控制doStartTag()方法返回EVAL_BODY_BUFFERED
     * @see javax.servlet.jsp.tagext.BodyTagSupport#doStartTag()
     */
    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {

        //this.getBodyContent()得到代表标签体的bodyContent对象
        BodyContent bodyContent = this.getBodyContent();
        //拿到标签体
        String content = bodyContent.getString();
        //修改标签体里面的内容，将标签体的内容转换成大写
        String result = content.toUpperCase();
        try {
            //输出修改后的内容
            this.pageContext.getOut().write(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return EVAL_PAGE;
    }
}
