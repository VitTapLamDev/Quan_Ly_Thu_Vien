/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.DAOUser;
import Controller.MessageDialogHelper;
import Model.User;
import View.UserManagementPanel;
import View.formAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class controllerUserManagement {
    
    private UserManagementPanel UserManagementPanel;
    private DAOUser DAOUser;
    private formAdmin formAdmin;

    public controllerUserManagement(UserManagementPanel view)
    {
        this.UserManagementPanel = view;
        DAOUser = new DAOUser();
        UserManagementPanel.addAddActionListener(new addUserListener());
        UserManagementPanel.addSearchActionListener(new searchListener());
        UserManagementPanel.addEditActionListener(new editListener());
        UserManagementPanel.addDeleteActionListener(new deleteListener());
        UserManagementPanel.addClickTable(new clickTableListener());
    }

    class clickTableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent evt) {
            try {
                DAOUser dao = new DAOUser();
                User User = dao.timUser(UserManagementPanel.getUserTable());
                if(User != null){
                    UserManagementPanel.setUser(User);
                }    
            } catch (Exception e) {
                MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
            }
            
        }      

        @Override
        public void mousePressed(MouseEvent e) {           
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {           
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {  
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    class searchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {           
            try {
                DAOUser dao = new DAOUser();
                User User = dao.timUser(UserManagementPanel.getSearch());
                if(User != null){
                    UserManagementPanel.setUser(User);
                    UserManagementPanel.showData(UserManagementPanel.getSearch());
                }
                else{
                    MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không tìm thấy người dùng");
                }           
            } catch (Exception e) {
                MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
            }
        }
    }

    class deleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (MessageDialogHelper.showConfirmDialog(formAdmin, "Hỏi", "Bạn có muốn xóa người dùng ?") == JOptionPane.NO_OPTION) {
                return;
            }
            if(UserManagementPanel.checkRong()){
                MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không được để trống thông tin");
            }
            else{
                try {
                    User User = UserManagementPanel.getUser();
                    DAOUser dao = new DAOUser();
                    if(dao.xoaUser(User)){
                        MessageDialogHelper.showMessageDialog(formAdmin, "Thông Báo", "Xóa người dùng thành công");
                        UserManagementPanel.showData("");
                        UserManagementPanel.reset();
                    }else{
                        MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Xóa người dùng thất bại");
                    }
                } catch (Exception e) {
                    MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
                }
            }
        }
    }

    class editListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (MessageDialogHelper.showConfirmDialog(formAdmin, "Hỏi", "Bạn có muốn cập nhật thông tin ?") == JOptionPane.NO_OPTION) {
                return;
            }
            if(UserManagementPanel.checkRong()){
                MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không được để trống thông tin");
            }
            else{
                try {
                    User User = UserManagementPanel.getUser();
                    DAOUser dao = new DAOUser();
                    if(dao.suaUser(User)){
                        MessageDialogHelper.showMessageDialog(formAdmin, "Thông Báo", "Sửa thông tin người dùng thành công");
                        UserManagementPanel.showData("");
                        UserManagementPanel.reset();
                    }else{
                        MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Sửa thông tin người dùng thất bại");
                    }
                } catch (Exception e) {
                    MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
                }
            }
        }
    }

    class addUserListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent evt) {           
            if (MessageDialogHelper.showConfirmDialog(formAdmin, "Hỏi", "Bạn có muốn thêm người dùng mới ?") == JOptionPane.NO_OPTION) {
                return;
            }              
            if(UserManagementPanel.checkRong()){
                MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không được để trống thông tin");
            }
            else{
                try {              
                    User User = UserManagementPanel.getUser();
                    DAOUser dao = new DAOUser();
                    if(dao.themUser(User)){
                        MessageDialogHelper.showMessageDialog(formAdmin, "Thông Báo", "Thêm người dùng mới thành công");
                        UserManagementPanel.showData("");
                        UserManagementPanel.reset();
                    }else{
                        MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Thêm người dùng mới thất bại");
                    }   
                } catch (Exception e) {
                    MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
                }
            }
        }
    }
}
