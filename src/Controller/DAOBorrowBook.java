/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BorrowBook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author VietNguyen
 */
public class DAOBorrowBook {
    //-----------------------Tạo Phiếu mượn
    public boolean taoPhieuMuon(BorrowBook muonSach)
        throws Exception{
            String sql = "UPDATE [dbo].[SACH]" + "SET [SoLuong] = SoLuong - 1 " + "WHERE MaSach = ?"
                    + "\n INSERT INTO [dbo].[muonSach]([MaSach], [MaSV] ,[NgayMuon])"                   
                    + " VALUES(?, ?, ?)";
            try (
                Connection con = DAO.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                    ){
                pstmt.setString(1, muonSach.getMaS());
                pstmt.setString(2, muonSach.getMaS());
                pstmt.setString(3, muonSach.getMaSV());
                pstmt.setString(4,muonSach.getNgayMuon());
                return pstmt.executeUpdate() > 0;
        }
    }
    //--------------------Trả Sách
    public boolean traSach(BorrowBook muonSach)
        throws Exception{
            String sql = "UPDATE [dbo].[SACH]" + "SET [SoLuong] = SoLuong + 1 " + "WHERE MaSach = ?"
                    + "\n DELETE [dbo].[muonSach]" + " WHERE MaSV = ? and MaSach = ?" 
                    + "\n INSERT INTO [dbo].[lichsu]([MaSach], [MaSV] ,[NgayMuon], [NgayTra])" 
                    + "VALUES(?, ?, ?, ?)";

            try (
                Connection con = DAO.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                    ){
                pstmt.setString(1, muonSach.getMaS());
                pstmt.setString(2, muonSach.getMaSV());
                pstmt.setString(3, muonSach.getMaS());
                pstmt.setString(4, muonSach.getMaS());
                pstmt.setString(5, muonSach.getMaSV());
                pstmt.setString(6, muonSach.getNgayMuon());
                pstmt.setString(7, muonSach.getNgayTra());
                return pstmt.executeUpdate() > 0;
        }
    }
    //------------------------Tìm Kiếm thông Tin
    public BorrowBook timThongTin(BorrowBook maSach)
            throws Exception{
                String sql = "SELECT * FROM dbo.muonSach" + " WHERE MaSV = ? and MaSach = ?";
                try (
                        Connection con = DAO.getConnection();
                        PreparedStatement pstmt = con.prepareStatement(sql);    
                    ){
                    pstmt.setString(1, maSach.getMaSV());
                    pstmt.setString(2, maSach.getMaS());
                    try(ResultSet rs = pstmt.executeQuery();){
                        if(rs.next()){
                            BorrowBook muonsach = new BorrowBook();
                            muonsach.setMaS(rs.getString("MaSach"));
                            muonsach.setMaSV(rs.getString("MaSV"));
                            muonsach.setNgayMuon(rs.getString("NgayMuon"));
                            return muonsach;
                        }
                    }
                    return null;        
            }
        }

    public boolean timKiemphieuMuon(String maSV)
        throws Exception{
                String sql = "SELECT * FROM [dbo].[muonSach]" + " WHERE MaSV LIKE '%" +maSV+"%'" ;
                Connection con = DAO.getConnection();
                Statement st = con.createStatement();    
                ResultSet rs =st.executeQuery(sql);
                while(rs.next()){
                    return true;
                }
                return false;   
}
    
    public boolean timKiemLichSu(String maSV)
        throws Exception{
                String sql = "SELECT * FROM [dbo].[lichSu]" + " WHERE MaSV LIKE '%" +maSV+"%'" ;
                Connection con = DAO.getConnection();
                Statement st = con.createStatement();    
                ResultSet rs =st.executeQuery(sql);
                while(rs.next()){
                    return true;
                }
                return false;   
}
    
   }