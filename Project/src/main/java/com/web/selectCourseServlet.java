package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Course;
import com.pojo.PageBean;
import com.service.SelectService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/selectCourseServlet")
public class selectCourseServlet extends HttpServlet {
    SelectService selectService = new SelectService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        BufferedReader br = request.getReader();
        String jsonCourse = br.readLine();

        Course course = JSON.parseObject(jsonCourse, Course.class);

        PageBean<Course> coursePageBean = selectService.selectCourse(currentPage,pageSize,course);

        String jsonString = JSON.toJSONString(coursePageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
