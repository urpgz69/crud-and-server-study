package com.sj.board.jquery;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sj.board.main.DBManager;
import com.sj.board.main.DBManager2;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HumanDAO {
    public static void test1(javax.servlet.http.HttpServletRequest request) {
       String name = request.getParameter("name");
       String age = request.getParameter("age");
        System.out.println(name);
        System.out.println(age);
    }

    public static void test2(HttpServletRequest request, HttpServletResponse response) {
        String str = "asdfasdf";
        //json
        JSONObject jsonObject = new JSONObject();
         jsonObject.put("string",str);
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter().println(jsonObject);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void test3(HttpServletRequest request, HttpServletResponse response) {
    Human h = new Human();
        h.setName("sdffw");
        h.setAge(23);
        JsonObject JObj = new JsonObject();
//        JObj.addProperty("name",h.getName());
//        JObj.addProperty("age",h.getAge());

        response.setContentType("application/json;charset=UTF-8");
        try {
//            System.out.println(h.toJson());
//            response.getWriter().println(h.toJson());
        //객체 키값 실어서 전송
        JsonObject obj = new JsonObject();
            JsonParser parser = new JsonParser();
            obj.add("person",parser.parse(h.toJson()));
            response.getWriter().println(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void test4(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        Human h2 = new Human(1, "mz1" ,10);
        Human h3 = new Human(2, "mz2" ,20);
        Human h4 = new Human(3, "mz3" ,30);
        System.out.println("-----------------");

        ArrayList<String> humans = new ArrayList<String>();
        humans.add(h2.toJson());
        humans.add(h3.toJson());
        humans.add(h4.toJson());
        System.out.println(humans);
        try {
            JsonObject obj = new JsonObject();
            JsonParser parser = new JsonParser();
            obj.add("people",parser.parse(humans.toString()));
            response.getWriter().println(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void test5(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
            Human human = new Human() ;
            ArrayList<String> humans = new ArrayList<>();
        try (Connection con = DBManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement("select * from human_test2");
             ResultSet rs = pstmt.executeQuery();
        ) {

            while (rs.next()) {
                human.setAge(rs.getInt("h_age"));
                human.setName(rs.getString("h_name"));
                human.setNo(rs.getInt("h_no"));
                humans.add(human.toJson());
            }
            System.out.println(humans);
            JsonObject obj = new JsonObject();
            JsonParser parser = new JsonParser();
            obj.add("people",parser.parse(humans.toString()));
            response.getWriter().println(obj);



        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
