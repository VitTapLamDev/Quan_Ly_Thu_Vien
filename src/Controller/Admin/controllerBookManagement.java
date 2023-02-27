/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.DAOBooks;
import Controller.MessageDialogHelper;
import Model.Books;
import View.BookManagementPanel;
import View.formAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class controllerBookManagement {
    private final BookManagementPanel BookManagementPanel;
    private final DAOBooks DAOBooks;
    private formAdmin formAdmin;
    
    public controllerBookManagement(BookManagementPanel view)
    {
        this.BookManagementPanel = view;
        DAOBooks = new DAOBooks();
        BookManagementPanel.addAddActionListener(new addBooksListener());
        BookManagementPanel.addSearchActionListener(new searchListener());
        BookManagementPanel.addEditActionListener(new editListener());
        BookManagementPanel.addDeleteActionListener(new deleteListener());
        BookManagementPanel.addClickTable(new clickTableListener());
    }

    class clickTableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent evt) {
            try {
                DAOBooks dao = new DAOBooks();
                Books Books = dao.timSach(BookManagementPanel.getBookTable());
                if(Books != null){
                    BookManagementPanel.setBook(Books);
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

    class deleteListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (MessageDialogHelper.showConfirmDialog(formAdmin, "Hỏi", "Bạn có muốn xóa sách ?") == JOptionPane.NO_OPTION) {
                return;
            }
            if(BookManagementPanel.checkRong()){
                MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không được để trống thông tin");
            }
            else{
                try {
                    Books Books = BookManagementPanel.getBook();
                    DAOBooks dao = new DAOBooks();
                    if(dao.xoaSach(Books)){
                        MessageDialogHelper.showMessageDialog(formAdmin, "Thông Báo", "Xóa sách thành công");
                        BookManagementPanel.showData("");
                        BookManagementPanel.reset();
                    }else{
                        MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Xóa sách thất bại");
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
            if(BookManagementPanel.checkRong()){
                MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không được để trống thông tin");
            }
            else{
                try {
                    Books Books = BookManagementPanel.getBook();
                    DAOBooks dao = new DAOBooks();
                    if(dao.suaSach(Books)){
                        MessageDialogHelper.showMessageDialog(formAdmin, "Thông Báo", "Sửa thông tin sách thành công");
                        BookManagementPanel.showData("");
                        BookManagementPanel.reset();
                        
                    }else{
                        MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Sửa thông tin sách thất bại");
                    }
                } catch (Exception e) {
                    MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
                }
            }
        }
    }
    

    class searchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                DAOBooks dao = new DAOBooks();
                Books Books = dao.timSach(BookManagementPanel.getSearch());
                if(Books != null){
                    BookManagementPanel.setBook(Books);
                    BookManagementPanel.showData(BookManagementPanel.getSearch());
                }
                else{
                    MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không tìm thấy sách");
                }           
            } catch (Exception e) {
                MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
            }
        }
    }

    class addBooksListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (MessageDialogHelper.showConfirmDialog(formAdmin, "Hỏi", "Bạn có muốn thêm sách mới ?") == JOptionPane.NO_OPTION) {
                return;
            }              
            if(BookManagementPanel.checkRong()){
                MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không được để trống thông tin");
            }
            else{
                try {              
                    Books Books = BookManagementPanel.getBook();
                    DAOBooks dao = new DAOBooks();
                    if(dao.themSach(Books)){
                        MessageDialogHelper.showMessageDialog(formAdmin, "Thông Báo", "Thêm sách mới thành công");
                        BookManagementPanel.showData("");
                        BookManagementPanel.reset();
                    }else{
                        MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Thêm sách mới thất bại");
                    }   
                } catch (Exception e) {
                    MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
                }
            }
        }
    }

  
}
