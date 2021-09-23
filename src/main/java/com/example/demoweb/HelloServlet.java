package com.example.demoweb;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;

@WebServlet(name = "helloServlet", value = {"*.html"})
public class HelloServlet extends HttpServlet {
    @Resource(name = "jdbc/privat")
    DataSource ds;

    private DirectorDAO directorDAO;

    private String message;

    public void init() {
        message = "Hello World!";
        try {
            Connection connection = ds.getConnection();
            directorDAO = new DirectorDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        List<Director> directors = directorDAO.findAll();
        out.println("<ul>");
        for (Director director : directors) {
            out.println("<li>"+director+"</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String btn = request.getParameter("btn");
        String username = request.getParameter("username") + " " + btn;
        String ageStr = request.getParameter("age");
        // try-catch
        int age = Integer.parseInt(ageStr);
        UserInfo ui = new UserInfo(username, age);
        request.setAttribute("ui", ui);
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
    }

    public void destroy() {
    }
}