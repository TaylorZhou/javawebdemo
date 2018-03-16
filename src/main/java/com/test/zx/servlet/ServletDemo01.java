package com.test.zx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.GZIPOutputStream;

public class ServletDemo01 extends HttpServlet {

   /* public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        *//**
         * 设置content-disposition响应头，让浏览器下载文件
         *//*
        response.setHeader("content-disposition", "attachment;filename=test_2.jpg");
        InputStream in = this.getServletContext().getResourceAsStream("test_2.jpg");
        byte buffer[] = new byte[1024];
        int len = 0;
        OutputStream out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }*/


}
