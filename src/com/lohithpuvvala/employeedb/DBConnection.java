package com.lohithpuvvala.employeedb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection != null) {
            return connection;
        }

        try{
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("C:/Users/lohit/Desktop/Projects/Internship Projects/Java-JDBC-Employee-Database-App/config.properties");
            props.load(fis);

            String dbUrl = props.getProperty("db.url");
            String dbUser = props.getProperty("db.username");
            String dbPassword = props.getProperty("db.password");

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
