package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Course;
import com.pojo.User;
import com.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/upDateTeacherServlet")
public class upDateTeacherServlet extends HttpServlet {
    SelectService selectService = new SelectService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用request.getReader() 获取 BufferedReader 对象
        BufferedReader bf = request.getReader();
        //用readLine() 读取请求体数据
        String s = bf.readLine();

        User user = JSON.parseObject(s, User.class);
        System.out.println(user);

        selectService.upDateTeacher(user);

        response.getWriter().write("delete:success");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
