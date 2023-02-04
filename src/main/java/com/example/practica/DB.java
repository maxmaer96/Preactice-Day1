package com.example.practica;

import java.sql.*;
import java.util.Map;

public class DB {

    private Connection dbConn = null;

    private Connection getDBConn() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String DATABASE_URL = "jdbc:mysql://localhost:3306/sp_2";
        String user = "root";
        String password = "Tarakan";

        String connectionURL = String.format(DATABASE_URL, Class.forName("com.mysql.cj.jdbc.Driver")) ;

        if (dbConn == null){
            dbConn = DriverManager.getConnection(
                    connectionURL,
                    user,
                    password
            );
        }

        return dbConn;
    }

    public Integer getEmployee(String number) throws SQLException, ClassNotFoundException {
        String sql ="SELECT count(*) FROM employees WHERE login='"+number+"';";
        Statement statement = getDBConn().createStatement();
        ResultSet result = statement.executeQuery(sql);
        Integer res = 0;
        while (result.next()){
            res = result.getInt(1);
        }
        return res;
    }

    public String getPassword(String number) throws SQLException, ClassNotFoundException {
        String sql ="SELECT employees.password FROM employees where login='"+number+"'";
        Statement statement = getDBConn().createStatement();
        ResultSet result = statement.executeQuery(sql);
        String res = "";
        while (result.next()){
            res = result.getString(1);
        }
        return res;

    }

    public String getRole(String number) throws SQLException, ClassNotFoundException {
        String sql ="SELECT posts.post FROM employees, posts where posts.PostId =  employees.PostId and employees.login = '"+number+"'";
        Statement statement = getDBConn().createStatement();
        ResultSet result = statement.executeQuery(sql);
        String res = "";
        while (result.next()){
            res = result.getString(1);
        }
        return res;
    }

}
