package com.sj.board.review;

import com.sj.board.main.DBManager;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO2 {
    public static final ReviewDAO2 REVIEW_DAO = new ReviewDAO2();
    public Connection con = null;
    private ReviewDAO2() {
        try {
            con = DBManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ReviewDTO> reviewList(HttpServletRequest request) {
        String sql = "select * from review_test";
        List<ReviewDTO> reviews = new ArrayList<>();

        try (
                Connection con = DBManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                ReviewDTO review = new ReviewDTO(rs.getInt("r_no"), rs.getString("r_title"), rs.getString("r_txt"), rs.getDate("r_date"));
                reviews.add(review);
            }
            request.setAttribute("review", reviews);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public void reviewAdd(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String sql = "insert into review_test values(review_test_seq.nextval,?,?,sysdate)";
        String title = request.getParameter("title");
        String text = request.getParameter("story");
        try (
                Connection con = DBManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, title);
            pstmt.setString(2, text);
            if (pstmt.executeUpdate() == 1) {
                System.out.println("add success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getReview(HttpServletRequest request) {
        String sql = "select * from review_test where r_no = ?";
        try (
                Connection con = DBManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ReviewDTO review = new ReviewDTO(
                            rs.getInt("r_no"),
                            rs.getString("r_title"),
                            rs.getString("r_txt"),
                            rs.getDate("r_date")
                    );
                    request.setAttribute("review2", review);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reviewUpdate(HttpServletRequest request) {
        String sql = "update review_test set r_title = ?, r_txt = ? where r_no = ?";

        try (
                Connection con = DBManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ){
          pstmt.setString(1,request.getParameter("reTitle"));
          pstmt.setString(2,request.getParameter("reText"));
          pstmt.setString(3,request.getParameter("reNo"));
          if(pstmt.executeUpdate() == 1){
              System.out.println("update success");
          }
        }catch (Exception e){
            e.printStackTrace();
        }




    }

    public void deleteReview(HttpServletRequest request) {
        String sql = "delete from review_test where r_no = ?";
        try (
                Connection con = DBManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);


                ){
            pstmt.setString(1, request.getParameter("no"));
            if (pstmt.executeUpdate()==1){
                System.out.println("delete success");
            }



        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public void paging(int pageNum, HttpServletRequest request) {
        List<ReviewDTO> reviews = reviewList(request);
        int total = reviews.size();
        int pagePerImg = 3 ;
        int totalPage = (int) (Math.ceil((double) total / pagePerImg));

        int startData = total - (pagePerImg * (pageNum - 1));
        int endData = (pageNum == totalPage) ? -1 : startData - pagePerImg;

        ArrayList<ReviewDTO> items = new ArrayList<>();
        for (int i = startData - 1; i >= endData && i >= 0; i--) {
            items.add(reviews.get(i));
        }

        request.setAttribute("review", items);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("curPage", pageNum);
    }
    
    
}
