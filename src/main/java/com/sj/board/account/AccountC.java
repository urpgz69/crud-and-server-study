package com.sj.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user-login")
public class AccountC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDAO.ACCOUNT_DAO.logout(request);
        response.sendRedirect("hello-servlet");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDAO.ACCOUNT_DAO.login(request);
        AccountDAO.ACCOUNT_DAO.loginCheck(request);
        request.setAttribute("content", "home.jsp");
request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    public void destroy() {
    }
}