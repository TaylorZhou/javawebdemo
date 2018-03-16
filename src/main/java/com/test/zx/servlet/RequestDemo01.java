package com.test.zx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Enumeration;

public class RequestDemo01 extends HttpServlet {

/*    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        *
         * 1.获得客户机信息

        String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
        String requestUri = request.getRequestURI();//得到请求的资源
        String queryString = request.getQueryString();//得到请求的URL地址中附带的参数
        String remoteAddr = request.getRemoteAddr();//得到来访者的IP地址
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteUser = request.getRemoteUser();
        String method = request.getMethod();//得到请求URL地址时使用的方法
        String pathInfo = request.getPathInfo();
        String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
        String localName = request.getLocalName();//获取WEB服务器的主机名
        response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("获取到的客户机信息如下：");
        out.write("<hr/>");
        out.write("请求的URL地址："+requestUrl);
        out.write("<br/>");
        out.write("请求的资源："+requestUri);
        out.write("<br/>");
        out.write("请求的URL地址中附带的参数："+queryString);
        out.write("<br/>");
        out.write("来访者的IP地址："+remoteAddr);
        out.write("<br/>");
        out.write("来访者的主机名："+remoteHost);
        out.write("<br/>");
        out.write("使用的端口号："+remotePort);
        out.write("<br/>");
        out.write("remoteUser："+remoteUser);
        out.write("<br/>");
        out.write("请求使用的方法："+method);
        out.write("<br/>");
        out.write("pathInfo："+pathInfo);
        out.write("<br/>");
        out.write("localAddr："+localAddr);
        out.write("<br/>");
        out.write("localName："+localName);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }*/

/*        public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
            //通过设置响应头控制浏览器以UTF-8的编码显示数据
            response.setHeader("content-type", "text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            Enumeration<String> reqHeadInfos = request.getHeaderNames();//获取所有的请求头
            out.write("获取到的客户端所有的请求头信息如下：");
            out.write("<hr/>");
            while (reqHeadInfos.hasMoreElements()) {
                String headName = (String) reqHeadInfos.nextElement();
                String headValue = request.getHeader(headName);//根据请求头的名字获取对应的请求头的值
                out.write(headName+":"+headValue);
                out.write("<br/>");
            }
            out.write("<br/>");
            out.write("获取到的客户端Accept-Encoding请求头的值：");
            out.write("<hr/>");
            String value = request.getHeader("Accept-Encoding");//获取Accept-Encoding请求头对应的值
            out.write(value);

            Enumeration<String> e = request.getHeaders("Accept-Encoding");
            while (e.hasMoreElements()) {
                String string = (String) e.nextElement();
                System.out.println(string);
            }
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
        }*/

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //客户端是以UTF-8编码提交表单数据的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
        request.setCharacterEncoding("UTF-8");
        /**
         * 编&nbsp;&nbsp;号(文本框)：
         <input type="text" name="userid" value="NO." size="2" maxlength="2">
         */
        String userid = request.getParameter("userid");//获取填写的编号，userid是文本框的名字，<input type="text" name="userid">
        /**
         * 用户名(文本框)：<input type="text" name="username" value="请输入用户名">
         */
        String username = request.getParameter("username");//获取填写的用户名
        /**
         * 密&nbsp;&nbsp;码(密码框)：<input type="password" name="userpass" value="请输入密码">
         */
        String userpass = request.getParameter("userpass");//获取填写的密码
        String sex = request.getParameter("sex");//获取选中的性别
        String dept = request.getParameter("dept");//获取选中的部门
        //获取选中的兴趣，因为可以选中多个值，所以获取到的值是一个字符串数组，因此需要使用getParameterValues方法来获取
        String[] insts = request.getParameterValues("inst");
        String note = request.getParameter("note");//获取填写的说明信息
        String hiddenField = request.getParameter("hiddenField");//获取隐藏域的内容

        String instStr = "";
        /**
         * 获取数组数据的技巧，可以避免insts数组为null时引发的空指针异常错误！
         */
        for (int i = 0; insts != null && i < insts.length; i++) {
            if (i == insts.length - 1) {
                instStr += insts[i];
            } else {
                instStr += insts[i] + ",";
            }
        }

        String htmlStr = "<table>" +
                "<tr><td>填写的编号：</td><td>{0}</td></tr>" +
                "<tr><td>填写的用户名：</td><td>{1}</td></tr>" +
                "<tr><td>填写的密码：</td><td>{2}</td></tr>" +
                "<tr><td>选中的性别：</td><td>{3}</td></tr>" +
                "<tr><td>选中的部门：</td><td>{4}</td></tr>" +
                "<tr><td>选中的兴趣：</td><td>{5}</td></tr>" +
                "<tr><td>填写的说明：</td><td>{6}</td></tr>" +
                "<tr><td>隐藏域的内容：</td><td>{7}</td></tr>" +
                "</table>";
        htmlStr = MessageFormat.format(htmlStr, userid, username, userpass, sex, dept, instStr, note, hiddenField);

        response.setCharacterEncoding("UTF-8");//设置服务器端以UTF-8编码输出数据到客户端
        response.setContentType("text/html;charset=UTF-8");//设置客户端浏览器以UTF-8编码解析数据
        response.getWriter().write(htmlStr);//输出htmlStr里面的内容到客户端浏览器显示
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
