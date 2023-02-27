/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyThuVien;encrypt=false"
                    , "sa", "123");

        } catch (ClassNotFoundException | SQLException e) {
        }
        return con;
    }
   // đổ dữ liệu từ SQl vào list Thu viên
}
