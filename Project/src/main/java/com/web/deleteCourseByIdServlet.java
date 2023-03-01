package com.web;

import com.alibaba.fastjson.JSON;
import com.service.SelectService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/deleteCourseServlet")
public class deleteCourseByIdServlet extends HttpServlet {
    SelectService selectService = new SelectService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bf = request.getReader();
        String s = bf.readLine();

        Integer id = JSON.parseObject(s, Integer.class);

        selectService.deleteCourseById(id);

        response.getWriter().write("delete:success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
