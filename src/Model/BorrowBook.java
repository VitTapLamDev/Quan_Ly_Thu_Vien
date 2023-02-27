/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author VietNguyen
 */
public class BorrowBook {
    public String MaSV;
    public String MaS;
    private String NgayMuon, HanTra, NgayTra;

    public BorrowBook() {
    }

    public BorrowBook(String MaSV, String MaS, String NgayMuon, String NgayTra) {
        this.MaSV = MaSV;
        this.MaS = MaS;
        this.NgayMuon = NgayMuon;
        this.NgayTra = NgayTra;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getMaS() {
        return MaS;
    }

    public void setMaS(String MaS) {
        this.MaS = MaS;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(String NgayTra) {
        this.NgayTra = NgayTra;
    }

  

        
}
