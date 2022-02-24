package net.jakemorris.stockfetch.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {

    public static Connection getConnection() {
        Properties props = new Properties();
        try {
            // Load secrets from local properties file
            props.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("stockfetch.properties"));
            // Connect to database
            try {
                Connection conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

