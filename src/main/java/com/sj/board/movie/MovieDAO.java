package com.sj.board.movie;

import com.sj.board.main.DBManager;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MovieDAO {
    public static final MovieDAO MOVIE_DAO = new MovieDAO();
    private MovieDAO() {

    }


    public  List<MovieDTO> getAllMovies() {
        String sql = "select * from movie_test";
        List<MovieDTO> movies = new ArrayList<>();

        try (
                Connection con = DBManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                MovieDTO movie = new MovieDTO(rs.getInt("m_number"), rs.getString("m_title"), rs.getString("m_actor"), rs.getString("m_img"), rs.getString("m_story"));
                movies.add(movie);
            }


        } catch (Exception e) {
            e.printStackTrace();

        }

        return movies;
    }

    public  void deleteMovie(HttpServletRequest request) {
        String sql = "delete from movie_test where m_number = ?";
       try(
        Connection con = DBManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql))
       {
           pstmt.setString(1, request.getParameter("num"));
            if (pstmt.executeUpdate()==1){
                System.out.println("delete success");
            }
       }catch (Exception e){
           e.printStackTrace();
       }

    }

    public  void insertMovie(MovieDTO dto) {
        String sql = "insert into movie_test values(movie_test_seq.nextval,?,?,?,?)";

        try(
                Connection con = DBManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);

                ){
            String img = dto.getImg();
            if (img != null) img = img.replace(" ", "_");

            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getActor());
            pstmt.setString(3, img );
            pstmt.setString(4, dto.getStory());
            if (pstmt.executeUpdate()==1){
                System.out.println("insert success");
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void updateMovie(MovieDTO dto) {
        StringBuilder sql = new StringBuilder("update movie_test set ");
            String title = dto.getTitle();
            String actor = dto.getActor();
            String img = dto.getImg();
            String story = dto.getStory();

            int idx = 1;
        if (title != null) sql.append("m_title = ?, ");
        if (actor != null) sql.append("m_actor = ?, ");
        if (img != null) {sql.append("m_img = ?, ");
        }
        if (story != null) sql.append("m_story = ?, ");
        sql.deleteCharAt(sql.lastIndexOf(","));
        sql.append("WHERE m_number = ?");
        try(
              Connection con = DBManager.getConnection();
              PreparedStatement pstmt = con.prepareStatement(sql.toString());
              )
        {
            if (title != null){ pstmt.setString(idx++, title);}
            if (actor != null) {pstmt.setString(idx++, actor);}
            if (img != null) {pstmt.setString(idx++, img); }
            if (story != null) {pstmt.setString(idx++,story);}

            pstmt.setInt(idx,dto.getNum());
            if (pstmt.executeUpdate() == 1) {

                System.out.println("update success");}
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public void paging(int pageNum, HttpServletRequest request) {
        List<MovieDTO> movies = getAllMovies();
        int total = movies.size();
        int pagePerImg = 3 ;
        int totalPage = (int) (Math.ceil((double) total / pagePerImg));

        int startData = total - (pagePerImg * (pageNum - 1));
        int endData = (pageNum == totalPage) ? -1 : startData - pagePerImg;

        ArrayList<MovieDTO> items = new ArrayList<>();
        for (int i = startData - 1; i >= endData && i >= 0; i--) {
            items.add(movies.get(i));
        }

        request.setAttribute("movies", items);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("curPage", pageNum);
    }









}