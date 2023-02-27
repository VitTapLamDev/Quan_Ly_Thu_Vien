/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.User;

import Controller.DAOUser;
import Controller.MessageDialogHelper;
import Model.User;
import View.formUser;
import View.userInforPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class controllerUserInfor {
    private formUser formUser;
    private DAOUser DAOUser;
    private userInforPanel userInforPanel;
    
    public controllerUserInfor(userInforPanel view){
        this.userInforPanel = view;
        DAOUser = new DAOUser();
        userInforPanel.addEditActionListener(new editListener());       
    }

    class editListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (MessageDialogHelper.showConfirmDialog(formUser, "Hỏi", "Bạn có muốn cập nhật thông tin ?") == JOptionPane.NO_OPTION) {
                return;
            }
            if(userInforPanel.checkRong()){
                MessageDialogHelper.showConfirmDialog(formUser, "Cảnh Báo", "Không được để trống thông tin");
            }
            else{
                try {
                    User User = userInforPanel.getUser();
                    DAOUser dao = new DAOUser();
                    if(dao.suaUser(User)){
                        MessageDialogHelper.showMessageDialog(formUser, "Thông Báo", "Sửa thông tin người dùng thành công");
                        userInforPanel.showData();
                    }else{
                        MessageDialogHelper.showConfirmDialog(formUser, "Cảnh Báo", "Sửa thông tin người dùng thất bại");
                    }
                } catch (Exception e) {
                    MessageDialogHelper.showErrorDialog(formUser,"Lỗi", e.getMessage());
                }
            }
        }
    }

    
}
