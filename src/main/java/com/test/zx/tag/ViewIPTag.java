package com.test.zx.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

/**
 * @author Taylor
 */
public class ViewIPTag implements Tag {

    private PageContext pageContext;

    public void setPageContext(PageContext pageContext) {
        System.out.println("setPageContext(PageContext pageContext)");
        this.pageContext = pageContext;
    }

    public void setParent(Tag tag) {
        System.out.println("调用setParent()方法");
    }

    public Tag getParent() {
        System.out.println("调用getParent()方法");
        return null;
    }

    public int doStartTag() throws JspException {
        System.out.println("调用doStartTag()方法");
        HttpServletRequest request =(HttpServletRequest) pageContext.getRequest();
        JspWriter out = pageContext.getOut();
        String ip = request.getRemoteAddr();
        try {
            //这里输出的时候会抛出IOException异常
            out.write(ip);
        } catch (IOException e) {
            //捕获IOException异常后继续抛出
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int doEndTag() throws JspException {
        System.out.println("调用doEndTag()方法");
        return 0;
    }

    public void release() {
        System.out.println("调用release()方法");
    }
}
