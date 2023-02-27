/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Books {
    private  String MaSach, TenSach, TheLoai;
    private int Soluong;

    public Books() {
    }

    public Books(String MaSach, String TenSach, String TheLoai, int SoLuong) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TheLoai = TheLoai;
        this.Soluong = SoLuong;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public Books(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }  
    
    @Override
    public String toString(){
        return "Books{" + "MaSach" + MaSach + ", TenSach" + TenSach +", TheLoai" + TheLoai + "}";
    }
}
