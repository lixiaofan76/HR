package com.qfedu.hr.servlet;

import com.qfedu.hr.pojo.PageBean;
import com.qfedu.hr.pojo.User;
import com.qfedu.hr.service.UserService;
import com.qfedu.hr.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-07
 * Time:    21:23
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    private static UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   /* //    获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数

    //    调用service
        PageBean<User> pageBean = null;
        try {
            pageBean = userService.findUserByPage(currentPage,rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //    将pageBean存入request中
        // request.setAttribute("pb",pageBean);
        request.getSession().setAttribute("pb",pageBean);
        request.getRequestDispatcher("user.jsp").forward(request,response);
*/



    }
}
