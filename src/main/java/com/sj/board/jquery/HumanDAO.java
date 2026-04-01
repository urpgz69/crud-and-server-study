package com.sj.board.jquery;

public class HumanDAO {
    public static void test1(javax.servlet.http.HttpServletRequest request) {
       String name = request.getParameter("name");
       String age = request.getParameter("age");
        System.out.println(name);
        System.out.println(age);
    }

}
