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

    public void editUser(HttpServletRequest request) {
            StringBuilder sql = new StringBuilder("update account_test set ");
            AccountVO user = (AccountVO) request.getSession().getAttribute("user");
            String id = user.getId();
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            if (pw == null && name == null){ return;}
            int idx = 1;
            if (pw != null) sql.append("a_pw = ?, ");
            if (name != null) sql.append("a_name = ?, ");
            sql.deleteCharAt(sql.lastIndexOf(","));
            sql.append("where a_id = ?");


            try(
                    Connection con = DBManager.getConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql.toString())
                    ){
                    if (pw != null){ pstmt.setString(idx++, pw);}
                    if (name != null) {pstmt.setString(idx++, name);}
                    pstmt.setString(idx,id);
                   if (pstmt.executeUpdate() == 1) {
                       System.out.println("update success");
                       user.setPw(pw !=null ? pw : user.getPw()
                       );
                       user.setName(name != null ? name : user.getName());
                       request.getSession().setAttribute("user",user);
                       request.getSession().setAttribute("msg2","update success");
                   }
            }catch (Exception e ){
                e.printStackTrace();
            }






    }
}
