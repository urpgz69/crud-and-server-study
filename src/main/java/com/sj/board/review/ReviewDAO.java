package com.sj.board.review;

import com.sj.board.main.DBManager2;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
    public static final ReviewDAO REVIEW_DAO = new ReviewDAO();
    private ReviewDAO() {
    }





    public List<ReviewDTO> reviewList(HttpServletRequest request) {
        String sql = "select * from review_test";
        List<ReviewDTO> reviews = new ArrayList<>();

        try (
                Connection con = DBManager2.connect();
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
                Connection con = DBManager2.connect();
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
                Connection con = DBManager2.connect();
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
                Connection con = DBManager2.connect();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ){
          pstmt.setString(1,request.getParameter("reTitle"));
          pstmt.setString(2,request.getParameter("reText"));
          pstmt.setInt(3, Integer.parseInt(request.getParameter("reNo")));
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
                Connection con = DBManager2.connect();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
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
        int pagePerImg = 5 ;
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

    public ArrayList<String> reviewSearch(HttpServletRequest request) {
        String sql = "select * from review_test where r_title like '%'||?||'%'";
        ArrayList<String> reviews = new ArrayList<>();
        String reviewTitle = request.getParameter("reviewTitle");
        ReviewDTO review = new ReviewDTO();
        try (
                Connection con = DBManager2.connect();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, reviewTitle);
            try(
                    ResultSet rs = pstmt.executeQuery();
                    ) {
                    while (rs.next()){
                        review.setReNo(rs.getInt("r_no"));
                        review.setReTitle(rs.getString("r_title"));
                        review.setReText(rs.getString("r_txt"));
                        review.setReDate(rs.getDate("r_date"));
                        reviews.add(review.toJson());
                    }
                    return reviews;

            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e ){
            e.printStackTrace();
        }
     return null;
    }
}
