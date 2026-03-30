package com.sj.board.review;

import com.sj.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/review-add")
public class ReviewUpC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {





    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ReviewDAO.REVIEW_DAO.reviewAdd(request);
        AccountDAO.ACCOUNT_DAO.loginCheck(request);
        response.sendRedirect("review");


    }

    public void destroy() {
    }
}