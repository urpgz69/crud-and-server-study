package com.sj.board.main;

import java.sql.*;

public class DBManager {

        private static final String URL = "jdbc:oracle:thin:@10.1.82.127:1521:XE";
        private static final String USER = "c##sj1004";
        private static final String PASSWORD = "sj1004";

        public static Connection getConnection() throws SQLException {
            Connection con = null;

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return con;
        }

        public static void close(Connection conn, Statement stmt, ResultSet rs) {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }








