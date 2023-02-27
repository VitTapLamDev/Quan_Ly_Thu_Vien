/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.formAdmin;
import View.formLogin;
import View.formUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class controllerLOGIN {

    private formLogin formLogin;
    private DAOlogin DAOlogin;
    private boolean temp;
    private formUser formUser;

    public controllerLOGIN(formLogin view) {
        this.temp = false;
        this.formLogin = view;
        DAOlogin = new DAOlogin();
        formLogin.addLoginListener(new addLoginListener());
    }

    public void showFormLogin() {
        formLogin.setVisible(true);
    }

    class addLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String tk = formLogin.tfUsername.getText();
            String mk = formLogin.tfPassword.getText();
            try {
                switch (DAOlogin.checkTaiKhoan(tk, mk)) {
                    case 11:
                        formLogin.showMessage("Đăng nhâp thành công tài khoản Admin");
                        new formAdmin().setVisible(true);                       
                        formLogin.setVisible(false);
                        break;
                    case 1:
                        if(checkBorrowBook(tk)==true){
                            formLogin.showMessage("Đăng nhâp thành công");
                            formLogin.showMessage("Bạn còn sách chưa trả!!");
                            new formUser(tk).setVisible(true);
                            formLogin.setVisible(false);
                        }
                        else{
                            formLogin.showMessage("Đăng nhâp thành công");
                            new formUser(tk).setVisible(true);
                            formLogin.setVisible(false);
                        }
                            
                        break;
                    default:
                        formLogin.showMessage("Đăng nhâp thất bại vui lòng kiểm tra lại tài khoản");
                        break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(controllerLOGIN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public boolean checkBorrowBook(String tk) throws SQLException{
        Connection connection = DAO.getConnection();
        String querry = "SELECT  tenDangNhap,matKhau,hoTen,users.maSV,gioiTinh,email,diaChi,muonSach.maSach, tenSach, theLoai, ngayMuon, hanTra" 
                    + " FROM muonSach, users, sach" 
                    + " WHERE muonSach.MaSV=users.MaSV AND muonSach.maSach=sach.maSach AND tenDangNhap = '"+ tk + "'";
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
            return false;
    }

}
