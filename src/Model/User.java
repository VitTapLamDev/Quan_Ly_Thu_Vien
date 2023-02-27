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
public class User {
    private String TaiKhoan, MatKhau, MaSV, HoTen,  Email, DiaChi, GioiTinh;

    public User() {
    }

    public User(String TaiKhoan, String MatKhau, String MaSV, String HoTen, String Email, String DiaChi, String Gioitinh) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    @Override
    public String toString() {
        return "user{" + "TaiKhoan=" + TaiKhoan + ", MatKhau=" + MatKhau + ", HoTen=" + HoTen + ", MaSV=" + MaSV
                + ", GioiTinh=" + GioiTinh + ", Email=" + Email + " DiaChi=" + DiaChi + '}';
    }

}
