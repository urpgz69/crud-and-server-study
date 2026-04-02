package com.sj.board.main;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
@WebListener
public class AppCleanupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 시작 시 특별히 할 것 없음
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // JDBC 드라이버 해제
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(drivers.nextElement());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}