package com.socialanalyzer.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private String url = "jdbc:mysql://localhost:3306/social_analyzer";
    private String user = "username";
    private String password = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

