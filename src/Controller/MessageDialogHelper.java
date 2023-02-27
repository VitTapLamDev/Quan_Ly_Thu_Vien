/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author VietNguyen
 */
public class MessageDialogHelper {
    public static void showMessageDialog(Component parent, String content, String tilte){
        JOptionPane.showMessageDialog(parent, tilte, content, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showErrorDialog(Component parent, String content, String tilte){
        JOptionPane.showMessageDialog(parent, tilte, content, JOptionPane.ERROR_MESSAGE);
    }
    public static int showConfirmDialog(Component parent, String content, String tilte){
        int choose = JOptionPane.showConfirmDialog(parent, tilte, content, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose;
                
    }
}
