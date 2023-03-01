package com.web;

import com.service.SelectService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/takeCourseServlet")
public class takeCourseServlet extends HttpServlet {
    SelectService selectService = new SelectService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _id = request.getParameter("id");
        String _courseId = request.getParameter("courseId");
        int id = Integer.parseInt(_id);
        int courseId = Integer.parseInt(_courseId);

        selectService.takeCourse(id,courseId);

        response.getWriter().write("success");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
