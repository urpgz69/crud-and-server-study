package com.sj.board.review;

import com.sj.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/review-search")
public class ReviewSearchC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //data뽑기
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(ReviewDAO.REVIEW_DAO.reviewSearch(request));


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }

    public void destroy() {
    }
}