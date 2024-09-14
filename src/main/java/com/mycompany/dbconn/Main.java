/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dbconn;

import java.sql.Connection;

/**
 *
 * @author athif
 */


public class Main {

    public static void main(String[] args) {
        DbConn db = new DbConn();
        Connection conn = db.connect_to_db("libraryManagement", "postgres", "123456");
//      db.insertRow(conn)
        
        //db.readData(conn);
        
    }

}
