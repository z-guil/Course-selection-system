package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Course;
import com.pojo.PageBean;
import com.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/addCourseServlet")
public class addCourseServlet extends HttpServlet {
    SelectService selectService = new SelectService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = request.getReader();
        String formdata = bufferedReader.readLine();

        Course course = JSON.parseObject(formdata, Course.class);


        selectService.addCourse(course);

        response.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
