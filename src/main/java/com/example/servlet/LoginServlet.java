package com.example.servlet;

import com.example.Users;

import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /* LoginServlet should:
 - be placed in com.example.filter package.
 - have url /login.
 - check session attribute "user".
 - for GET request if the session attribute "user" exists, redirect to the /login.jsp page, else redirect to the /user/hello.jsp.
 - for POST request check the request attribute "login" in Users and the request attribute "password" on being blank.
   If attributes are correct set session attribute "user" and redirect to /user/hello.jsp, else forward to the /login.jsp. */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") == null){
            resp.sendRedirect("/login.jsp");
        }else{
            resp.sendRedirect("/user/hello.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean rightName = Users.getInstance().getUsers().contains(login);
        boolean rightPass = !password.isEmpty();

        if (rightName && rightPass) {
            req.getSession().setAttribute("user", login);
            resp.sendRedirect("/user/hello.jsp");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
