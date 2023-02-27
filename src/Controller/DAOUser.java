/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.DAO;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VietNguyen
 */
public class DAOUser {
    
    public List<User> getListSinhVien() throws SQLException {
        List<User> listUser = new ArrayList<>();
          DAO d1=new DAO();
        Connection conn= DAO.getConnection();
        try {
            ResultSet rs;
            try (Statement st = conn.createStatement()) {
                rs = st.executeQuery("select * from users");
                while (rs.next()) {
                    String tk = rs.getString("tenDangNhap");
                    String mk = rs.getString("matKhau");
                    String maSV = rs.getString("maSV");
                    String ht = rs.getString("hoTen");
                    String email = rs.getString("email");
                    String gt = rs.getString("gioiTinh");
                    String dc = rs.getString("diaChi");
                    User User= new User(tk,mk,maSV,ht,email,gt,dc);
                    listUser.add(User);
                }   }
        rs.close();
        } catch (Exception e) {
        }
       return listUser ;
    }
    
    //--------------Dao Thêm User
    public boolean themUser(User user)
            throws Exception{
                String sql = "INSERT INTO [dbo].[users]([tenDangNhap], [matKhau], [maSV], [hoTen], [email], [gioiTinh], [diaChi])" 
                        + " VALUES(?, ?, ?, ?, ?, ?, ?)";
                try (
                        Connection con = DAO.getConnection();
                        PreparedStatement pstmt = con.prepareStatement(sql);    
                    ){
                    pstmt.setString(1, user.getTaiKhoan());
                    pstmt.setString(2, user.getMatKhau());
                    pstmt.setString(3, user.getMaSV());
                    pstmt.setString(4, user.getHoTen());
                    pstmt.setString(5, user.getEmail());
                    pstmt.setString(6, user.getGioiTinh());
                    pstmt.setString(7, user.getDiaChi());
                    return pstmt.executeUpdate()>0;
            }
        }
    //-----------------------------Sửa user
    public boolean suaUser(User user)
            throws Exception{
                String sql = "UPDATE [dbo].[users]" + " SET [tenDangNhap]= ?,[matKhau] = ? ,[maSV] = ? ,[hoTen] = ? ,[email] = ? ,[gioiTinh] = ? ,[diaChi] = ?" 
                        + " WHERE maSV = ?";
                try (
                        Connection con = DAO.getConnection();
                        PreparedStatement pstmt = con.prepareStatement(sql);    
                    ){
                    pstmt.setString(1, user.getTaiKhoan());
                    pstmt.setString(2, user.getMatKhau());
                    pstmt.setString(3, user.getMaSV());
                    pstmt.setString(4, user.getHoTen());
                    pstmt.setString(5, user.getEmail());
                    pstmt.setString(6, user.getGioiTinh());
                    pstmt.setString(7, user.getDiaChi());
                    pstmt.setString(8, user.getMaSV());
                    return pstmt.executeUpdate()>0;
            }
        }
    //-------------------------Xóa User
    public boolean xoaUser(User user)
            throws Exception{
                String sql = "DELETE FROM [dbo].[users]" + " WHERE maSV = ?";
                try (
                        Connection con = DAO.getConnection();
                        PreparedStatement pstmt = con.prepareStatement(sql);    
                    ){
                    pstmt.setString(1, user.getMaSV());
                    return pstmt.executeUpdate()>0;
            }
        }
    
    //-------------------------Tìm kiếm user
    public User timUser(String MaSV)
            throws Exception{
                String sql = "SELECT [tenDangNhap], [matKhau], [maSV], [hoTen], [email] , [gioiTinh], [diaChi]"  
                        + "  FROM [dbo].[users]" + " WHERE MaSV LIKE '%"+MaSV+"%'";
                try (
                        Connection con = DAO.getConnection();
                        Statement st = con.createStatement();
                    ){
                    try(ResultSet rs = st.executeQuery(sql)){
                        if(rs.next()){
                            User user = new User();
                            user.setTaiKhoan(rs.getString("tenDangNhap"));
                            user.setMatKhau(rs.getString("matKhau"));
                            user.setMaSV(rs.getString("maSV"));
                            user.setHoTen(rs.getString("hoTen"));
                            user.setGioiTinh(rs.getString("gioiTinh"));
                            user.setEmail(rs.getString("email"));
                            user.setDiaChi(rs.getString("diaChi"));
                            return user;
                        }
                    }
                    return null;        
            }
        }
}
