package com.sj.board.account;

import com.sj.board.main.DBManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
        public static final AccountDAO ACCOUNT_DAO = new AccountDAO();
        private AccountDAO(){}

    public boolean loginCheck(HttpServletRequest request){
AccountVO user =  (AccountVO) request.getSession().getAttribute("user");
if (user!= null){
    request.setAttribute("loginPage", "jsp/account/login-ok.jsp");
    return true;
}else {request.setAttribute("loginPage", "jsp/account/login.jsp");}
return false;
    }


    public void login(HttpServletRequest request){
        String id =  request.getParameter("id");
       String pw =  request.getParameter("pw");
       String sql = "select * from account_test where a_id = ?";
        try(
                Connection con = DBManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)

        ){
            pstmt.setString(1, id);
            try( ResultSet rs = pstmt.executeQuery()) {

                String msg = "id error";
                if (rs.next()) {
                    if (rs.getString("a_pw").equals(pw)) {
                        System.out.println("login success");
                        msg = "login success";
                        request.setAttribute("loginPage", "jsp/account/login-ok.jsp");
                        AccountVO aVO = new AccountVO(rs.getString("a_id"),
                                rs.getString("a_pw"),
                                rs.getString("a_name"));
                        HttpSession hs = request.getSession();
                        hs.setAttribute("user", aVO);
                        hs.setMaxInactiveInterval(5*60);
                    } else {
                        System.out.println(id);
                        System.out.println(pw);
                        System.out.println("pw error");
                        msg = "pw error";
                    }
                }
                    request.setAttribute("msg", msg);
                }catch(Exception e){
                    e.printStackTrace();
                }


        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void logout(HttpServletRequest request) {
            HttpSession session = request.getSession();
           // session.invalidate(); 전 세션 초기화
           // session.removeAttribute("user"); 특정 세션 초기화
            session.setAttribute("user",null);

    }

    public boolean deleteUser(HttpServletRequest request) {
        String password = request.getParameter("password");
        String id = request.getParameter("id");

        String selectSql = "select a_pw from account_test where a_id = ?";
        String deleteSql = "delete from account_test where a_id = ?";

        try (
                Connection con = DBManager.getConnection();
                PreparedStatement selectPstmt = con.prepareStatement(selectSql)
        ) {
            selectPstmt.setString(1, id);
            try (ResultSet rs = selectPstmt.executeQuery()) {
                if (rs.next() && rs.getString("a_pw").equals(password)) {
                    try (PreparedStatement deletePstmt = con.prepareStatement(deleteSql)) {
                        deletePstmt.setString(1, id);
                        deletePstmt.executeUpdate();
                        request.getSession().invalidate();
                        return true;
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
