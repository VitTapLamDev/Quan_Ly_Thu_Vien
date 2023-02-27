/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.DAOBorrowBook;
import Controller.MessageDialogHelper;
import Model.BorrowBook;
import View.HistoryPanel;
import View.formAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Administrator
 */
public class controllerHistory {
    
    private formAdmin formAdmin;
    private HistoryPanel HistoryPanel;
    private DAOBorrowBook DAOBorrowBook;
    
    public controllerHistory(HistoryPanel view)
    {
        this.HistoryPanel = view;
        DAOBorrowBook dao = new DAOBorrowBook();
        HistoryPanel.addSearchActionListener(new searchListener());       
    }

    class searchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                DAOBorrowBook dao = new DAOBorrowBook();
                if(dao.timKiemLichSu(HistoryPanel.getSearch())==true){
                    HistoryPanel.showData(HistoryPanel.getSearch());     
                }
                else{
                    MessageDialogHelper.showConfirmDialog(formAdmin, "Cảnh Báo", "Không tìm thấy phiếu mượn");
                }           
            } catch (Exception e) {
                MessageDialogHelper.showErrorDialog(formAdmin,"Lỗi", e.getMessage());
            }
        }
    }
    
}
