package com.socialanalyzer.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/social_analyzer";
        String password = "password";
        String user = "username";
        return DriverManager.getConnection(url, user, password);
    }
}

