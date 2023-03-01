package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.PageBean;
import com.pojo.User;
import com.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/selectStudentServlet")
public class selectStudentServlet extends HttpServlet {
    SelectService selectService = new SelectService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        BufferedReader br = request.getReader();
        String jsonUser = br.readLine();

        User user = JSON.parseObject(jsonUser, User.class);

        PageBean<User> userPageBean = selectService.selectStudent(currentPage,pageSize,user);

        String jsonString = JSON.toJSONString(userPageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
