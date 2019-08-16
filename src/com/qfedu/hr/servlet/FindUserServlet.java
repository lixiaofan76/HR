package com.qfedu.hr.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.hr.pojo.Applicant;
import com.qfedu.hr.service.UserService;
import com.qfedu.hr.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-12
 * Time:    15:13
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    private static UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        //期望服务器响应回的数据格式：{"userExsit":true,"msg":"此用户名太受欢迎,请更换一个"}
        //                         {"userExsit":false,"msg":"用户名可用"}
        //调用service方法
        Applicant appByName = null;
        try {
             appByName = userService.findAppByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();

        if (appByName != null) {
            map.put("userExsit",true);
            map.put("msg","该用户名已被注册！");
        } else {
            map.put("userExsit",false);
            map.put("msg","用户名可用");
        }

        //设置响应的数据格式json
        response.setContentType("application/json;charset=utf-8");
        System.out.println("test");
        //将map转为json，并且传递给客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);

    }
}
