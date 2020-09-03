package controller;

import bean.Result;
import service.StasticData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/StasticServlet")
public class StasticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StasticData service = new StasticData();
        List list1 = null;
        try {
            list1 = service.getList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("list",list1);
        req.getRequestDispatcher("successPage.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
