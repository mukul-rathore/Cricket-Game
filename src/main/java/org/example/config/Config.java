package org.example.config;

import java.sql.*;
public class Config{
    private static Connection connection;
    private Config(){};
    private static Connection connectToSql(){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "password";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            stmt.execute("use Cricket");
            System.out.println("Connected to the MySQL server successfully.");
        }
        catch(SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    public static Connection getConnection(){
        if(Config.connection == null){
            Config.connection = Config.connectToSql();
        }
        return Config.connection;
    }
}