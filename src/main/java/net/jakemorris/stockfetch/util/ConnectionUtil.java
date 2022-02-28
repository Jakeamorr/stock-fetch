package net.jakemorris.stockfetch.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static Connection conn;

    // Static method for returning a connection to the database
    public static Connection getConnection() {
        if (conn == null) {
            Properties props = new Properties();
            try {
                // Load secrets from local file
                props.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("stockfetch.properties"));
                // Attempt connection to the database
                // Cannot use try-with-resource since it will close the connection early...
                // try (Connection conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"))) {
                try  {
                    conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
                    return conn;
                } catch(SQLException sqle) {
                    sqle.printStackTrace();
                }
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        }

        return conn;
    }

    @Override
    protected void finalize() throws Throwable {
       conn.close();
    }
}

