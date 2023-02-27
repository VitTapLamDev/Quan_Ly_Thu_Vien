/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.DAOBorrowBook;
import Controller.MessageDialogHelper;
import Model.BorrowBook;
import View.BorrowBooksManagementPanel;
import View.formAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class controllerBorrowBooksManagement {
    private formAdmin formAdmin;
    private final BorrowBooksManagementPanel BorrowBooksManagementPanel;
    private final DAOBorrowBook DAOBorrowBook;
    
    public controllerBorrowBooksManagement(BorrowBooksManagementPanel view){
        this.BorrowBooksManagementPanel = view;
        DAOBorrowBook = new DAOBorrowBook();
        BorrowBooksManagementPanel.addAddActionListener(new addBorrowListener());
        BorrowBooksManagementPanel.addSearchActionListener(new searchListener());
        BorrowBooksManagementPanel.addEditActionListener(new editListener());
        BorrowBooksManagementPanel.addClickTable(new clickTableListener());
        
    }

    class clickTableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent evt) {
            try {
                DAOBorrowBook dao = new DAOBorrowBook();
                BorrowBook BorrowBook = dao.timThongTin(BorrowBooksManagementPanel.getBorrowBookTable());
                if(BorrowBook != null){
                    BorrowBooksManagementPanel.setBorrowBook(BorrowBook);
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

    class editListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (MessageDialogHelper.showConfirmDialog(formAdmin, "Hỏi", "Bạn có muốn trả sách ?") == JOptionPane.NO_OPTION) {
                return;
            }
            if(BorrowBooksManagementPanel.checkRong()){
                MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không được để trống thông tin");
            }
            else{
                try {
                    BorrowBook BorrowBook = BorrowBooksManagementPanel.getBorrowBook();
                    DAOBorrowBook dao = new DAOBorrowBook();
                    BorrowBook = dao.timThongTin(BorrowBook);
                    Date d = new Date(System.currentTimeMillis());
                    BorrowBook.setNgayTra((d.getYear()+1900)+"/"+(d.getMonth()+1)+"/"+d.getDate());
                    if(dao.traSach(BorrowBook)){
                        MessageDialogHelper.showMessageDialog(formAdmin, "Thông Báo", "Trả sách thành công");
                        BorrowBooksManagementPanel.showData("");
                        BorrowBooksManagementPanel.reset();
                    }else{
                        MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Mã Sinh Viên hoặc Mã Sách không đúng! \nVui Lòng xem lại");
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
                BorrowBook BorrowBook = BorrowBooksManagementPanel.getBorrowBook();
                DAOBorrowBook dao = new DAOBorrowBook();
                if(dao.timKiemphieuMuon(BorrowBook.getMaSV())==true){
                    BorrowBooksManagementPanel.showData(BorrowBook.getMaSV());
                }
                else{
                    MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không tìm thấy phiếu mượn");
                }           
            } catch (Exception e) {
                MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
            }
        }
    }

    class addBorrowListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (MessageDialogHelper.showConfirmDialog(formAdmin, "Hỏi", "Bạn có muốn tạo phiếu mượn ?") == JOptionPane.NO_OPTION) {
                return;
            }              
            if(BorrowBooksManagementPanel.checkRong()){
                MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không được để trống thông tin");
            }
            else{
                try {              
                    BorrowBook BorrowBook = BorrowBooksManagementPanel.getBorrowBook();                    
                    Date d = new Date(System.currentTimeMillis());
                    BorrowBook.setNgayMuon((d.getYear()+1900)+"/"+(d.getMonth()+1)+"/"+d.getDate());
                    DAOBorrowBook dao = new DAOBorrowBook();
                    if(dao.taoPhieuMuon(BorrowBook)){ 
                        MessageDialogHelper.showMessageDialog(formAdmin, "Thông Báo", "Tạo phiếu mượn sách mới thành công");
                        BorrowBooksManagementPanel.showData("");
                        BorrowBooksManagementPanel.reset();
                    }else{
                        MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Tạo phiếu mượn sách mới thất bại");
                    }   
                } catch (Exception e) {
                    MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
                }
            }
        }
    }
}
