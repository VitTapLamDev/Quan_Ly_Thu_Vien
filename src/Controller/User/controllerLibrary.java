/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.User;

import Controller.DAOBooks;
import Controller.MessageDialogHelper;
import Model.Books;
import View.formUser;
import View.libraryPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class controllerLibrary {
    private libraryPanel libraryPanel;
    private DAOBooks DAOBooks;
    private formUser formUser;
    
    public controllerLibrary(libraryPanel view)
    {
        this.libraryPanel = view;
        DAOBooks = new DAOBooks();
        libraryPanel.addSearchActionListener(new searchListener());
        libraryPanel.addClickTable(new clickTableListener());
    }

    class clickTableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent evt) {
            try {
                DAOBooks dao = new DAOBooks();
                Books Books = dao.timSach(libraryPanel.getBookTable());
                if(Books != null){
                    libraryPanel.setBook(Books);
                }    
            } catch (Exception e) {
                MessageDialogHelper.showErrorDialog(formUser,"Lỗi", e.getMessage());
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
                DAOBooks dao = new DAOBooks();
                Books Books = dao.timSach(libraryPanel.getSearch());
                if(Books != null){
                    libraryPanel.setBook(Books);
                    libraryPanel.showData(libraryPanel.getSearch());
                }
                else{
                    MessageDialogHelper.showConfirmDialog(formUser, "Cảnh Báo", "Không tìm thấy sách");
                }           
            } catch (Exception e) {
                MessageDialogHelper.showErrorDialog(formUser,"Lỗi", e.getMessage());
            }
        }
    }

    
}

