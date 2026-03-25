package com.sj.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user-info")
public class AccountInfoC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
     //id 조회 필요 x 세션이 이미 있음
        if (AccountDAO.ACCOUNT_DAO.loginCheck(request)){
        request.setAttribute("content","jsp/account/my-page.jsp");}
        else {
            request.setAttribute("content","home.jsp");
        }
    request.getRequestDispatcher("index.jsp").forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    if(
        !AccountDAO.ACCOUNT_DAO.loginCheck(request)){
        response.sendRedirect("home.jsp");
        return;
    }

    if(AccountDAO.ACCOUNT_DAO.deleteUser(request) ){
        request.setAttribute("content","jsp/account/deleteSuccess.jsp");
        request.setAttribute("loginPage", "jsp/account/login.jsp");
        request.getSession().setAttribute("msg2","delete success");}
    else {
        request.setAttribute("content","jsp/account/my-page.jsp");
        request.getSession().setAttribute("msg2","delete failed");
    }
    request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}