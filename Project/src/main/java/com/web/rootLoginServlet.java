package com.web;

import com.pojo.User;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/rootLoginServlet")
public class rootLoginServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
        String password = request.getParameter("password");

        User user = userService.selectFromRoot(id, password);

        if (user!=null){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("false");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
