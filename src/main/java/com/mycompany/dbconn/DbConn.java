/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dbconn;

/**
 *
 * @author athif
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConn {
    
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            // Mendaftarkan driver PostgreSQL
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection established");
            } else {
                System.out.println("Connection failed");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found. Include it in your library path.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
////////    public void readData(Connection conn){
////////        
////////        Statement statement =null;
////////        String query = "SELECT * FROM customer";
////////        
////////        try {
////////            statement= conn.createStatement();
////////            ResultSet rs= statement.executeQuery(query);
////////            
////////            while(rs.next()){
////////                String custId = rs.getString("customer_name");
////////                System.out.println("Nama Customer: "+custId);
////////            }
////////        } catch (SQLException e) {
////////            System.out.println(e.getMessage());
////////        } finally {
////////            if (statement != null) {
////////                try {
////////                    statement.close();
////////                } catch (SQLException e) {
////////                    System.out.println(e.getMessage());
////////                }
//////            }
////        }
//    }
}
