package com.sj.board.movie;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class MovieUpdateC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        request.setAttribute("content","/jsp/movie/movie.jsp");
        request.setAttribute("movies", MovieDAO.MOVIE_DAO.getAllMovies(request));
        request.getRequestDispatcher("index.jsp").forward(request,response);




    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String contentType = request.getContentType();



        if (contentType != null && contentType.contains("multipart")) {
            String path  = "C:\\lsj\\upload\\thumb";
            MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 20, "utf-8", new DefaultFileRenamePolicy());
            MovieDTO dto = new MovieDTO();
            dto.setTitle(multi.getParameter("title"));
            dto.setActor(multi.getParameter("actor"));
            dto.setImg(multi.getFilesystemName("file"));
            dto.setStory(multi.getParameter("story"));
            dto.setNum(Integer.parseInt(multi.getParameter("num")));
            if (multi.getParameter("crud").equals("c")) {
                MovieDAO.MOVIE_DAO.insertMovie(dto);
            } else if (multi.getParameter("crud").equals("u")) {
                MovieDAO.MOVIE_DAO.updateMovie(dto);
            }
        }else{
            String crud = request.getParameter("crud");
            if (crud.equals("d"))
        { MovieDAO.MOVIE_DAO.deleteMovie(request);}}
     response.sendRedirect("movie");
    }

    public void destroy() {
    }
}