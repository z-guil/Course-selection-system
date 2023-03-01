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

@WebServlet("/selectCourse_SelectedServlet")
public class selectCourse_selectedServlet extends HttpServlet {
    SelectService selectService = new SelectService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String _id = request.getParameter("id");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        int id = Integer.parseInt(_id);
        BufferedReader br = request.getReader();
        String jsonCourse = br.readLine();

        Course course = JSON.parseObject(jsonCourse, Course.class);

        PageBean<Course> coursePageBean = selectService.selectCourse_Selected(currentPage,pageSize,course,id);

        String jsonString = JSON.toJSONString(coursePageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
