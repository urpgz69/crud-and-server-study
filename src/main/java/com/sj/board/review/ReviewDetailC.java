package com.sj.board.review;

import com.sj.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/review-detail")
public class ReviewDetailC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDAO.ACCOUNT_DAO.loginCheck(request);
        ReviewDAO.REVIEW_DAO.getReview(request);
        request.setAttribute("content", "/jsp/review/review-detail.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }

    public void destroy() {
    }
}