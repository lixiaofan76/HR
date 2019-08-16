package com.qfedu.hr.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-03
 * Time:    14:42
 */
public class MessageRequest {

    public static void messageRequestDispatcher(HttpServletRequest request, HttpServletResponse response, String msg, String path) throws ServletException, IOException {
        request.setAttribute("msg", msg);
        request.getRequestDispatcher(path).forward(request, response);
    }
}
