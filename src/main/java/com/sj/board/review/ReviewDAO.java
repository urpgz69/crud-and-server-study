package com.sj.board.review;

import com.sj.board.main.DBManager;
import com.sj.board.movie.MovieDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ReviewDAO {
public static final ReviewDAO REVIEW_DAO = new ReviewDAO();
    private ReviewDAO() {

    }

    public List<ReviewDTO> reviewList(HttpServletRequest request) {
        String sql = "select * from review_test";
        List<ReviewDTO> reviews = null;

        try (
                Connection con = DBManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
                ){
            while(rs.next()){
                ReviewDTO review = new ReviewDTO(rs.getInt("r_no"),rs.getString("r_title"),rs.getString("r_txt"),rs.getDate("r_date"));
                reviews.add(review);
                request.setAttribute("review",reviews);
            }




        }catch (Exception e){ e.printStackTrace();}
    return reviews;
    }
}
