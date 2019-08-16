package com.qfedu.hr.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求中method参数的名字
        String methodName = req.getParameter("method");

        /*
         2. 获取Class类对象，获取当前Servlet程序的Class类对象
         获取的数据类型是Class类对象，并且是存在泛型约束，要求是BaseServlet或者其子类
        */
        Class<? extends BaseServlet> aClass = this.getClass();

        try {
            /*
            3. 根据 method和 Class类对象，获取对应的方法
            而业务逻辑需要处理的方法都可以认为是service方法，需要的参数都是HttpServletRequest
            和HttpServletResponse
             */
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            /*
             4. 执行对应的方法，执行方法的对象时当前 BaseServlet对象或者其子类
             执行需要的参数就是 HttpServletRequest对象和HttpServletResponse对象
            */
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
