package com.web;

import com.pojo.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/teacherLoginServlet")
public class teacherLoginServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
        String password = request.getParameter("password");

        User user = userService.selectFromTeacher(id, password);

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
