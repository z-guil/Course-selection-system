package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.SelectService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/showNameListServlet")
public class showNameListServlet extends HttpServlet {
    SelectService selectService = new SelectService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _id = request.getParameter("id");
        int id = Integer.parseInt(_id);

        List<User> users = selectService.showNameList(id);
        String jsonString = JSON.toJSONString(users);

        response.setContentType("text/json;charset=utf-8");

        response.getWriter().write(jsonString);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
