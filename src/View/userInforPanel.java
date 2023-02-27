/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DAO;
import Controller.DAOUser;
import Controller.MessageDialogHelper;
import Model.User;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class userInforPanel extends javax.swing.JPanel {
    
    private formUser formUser;
    String tk="";
    String temp="";
    
    public userInforPanel() {
        initComponents();
    }
    public userInforPanel(String TK) {
        tk=TK;
        initComponents();
    }

    public void showData(){
        try {
            TableUsers.removeAll();
            String[] arr = {"Mã Sách", "Tên Sách", "Thể Loại", "Ngày Mượn", "Hạn Trả"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            Connection connection = DAO.getConnection();
            
            String querry = "SELECT  tenDangNhap,matKhau,hoTen,maSV,gioiTinh,email,diaChi" + " FROM users" 
                    + " WHERE tenDangNhap = '"+ tk + "'";              
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                txt_password.setText(rs.getString("matKhau"));
                txt_name.setText(rs.getString("hoTen"));
                txt_MaSV.setText(rs.getString("maSV"));
                temp=rs.getString("maSV");
                txt_email.setText(rs.getString("email"));
                txt_Address.setText(rs.getString("diaChi"));
                String sex=rs.getString("gioiTinh");
                if("Nam".equals(sex))
                    jRadio_Nam.doClick();
                else
                {
                    if("Nữ".equals(sex))
                        JRadio_Nu.doClick();
                    else
                        JRadio_khac.doClick();
                }
            }
           
            querry = "SELECT  maSV,muonSach.maSach, tenSach, theLoai, ngayMuon, hanTra" 
                    + " FROM muonSach, sach" 
                    + " WHERE muonSach.maSach=sach.maSach AND maSV = '"+ temp + "'"+ "ORDER BY ngayMuon";
              
            ps = connection.prepareStatement(querry);
            ps.executeQuery();
            rs = ps.executeQuery();
            while(rs.next()){
                Vector vector = new Vector();
                vector.add(rs.getString("maSach"));
                vector.add(rs.getString("tenSach"));
                vector.add(rs.getString("theLoai"));
                vector.add(rs.getString("ngayMuon"));
                vector.add(rs.getString("hanTra"));
                model.addRow(vector);
            }
            TableUsers.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(libraryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup_Sex = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jB_password = new javax.swing.JLabel();
        jB_name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jB_Sex = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_MaSV = new javax.swing.JTextField();
        jRadio_Nam = new javax.swing.JRadioButton();
        JRadio_Nu = new javax.swing.JRadioButton();
        JRadio_khac = new javax.swing.JRadioButton();
        txt_email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Address = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btn_edit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jB_book = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableUsers = new javax.swing.JTable();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jB_password.setText("Mật Khẩu:");

        jB_name.setText("Họ Tên:");

        jLabel4.setText("Mã SV: ");

        jB_Sex.setText("Giới Tính:");

        jLabel6.setText("Email:");

        jLabel7.setText("Địa Chỉ:");

        btnGroup_Sex.add(jRadio_Nam);
        jRadio_Nam.setText("Nam");

        btnGroup_Sex.add(JRadio_Nu);
        JRadio_Nu.setText("Nữ");

        btnGroup_Sex.add(JRadio_khac);
        JRadio_khac.setText("Khác");

        txt_Address.setColumns(20);
        txt_Address.setRows(5);
        jScrollPane1.setViewportView(txt_Address);

        btn_edit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhNen/Icon/Actions-document-edit-icon.png"))); // NOI18N
        btn_edit.setText("Sửa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btn_edit)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jB_book.setText("Danh sách sách đang mượn");

        TableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Thể loại", "Ngày Mượn", "Hạn Trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TableUsers);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jB_Sex))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(txt_email)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRadio_Nam)
                                        .addGap(18, 18, 18)
                                        .addComponent(JRadio_Nu)
                                        .addGap(18, 18, 18)
                                        .addComponent(JRadio_khac)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jB_name, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_name))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jB_password)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_password)
                                            .addComponent(txt_MaSV))))
                                .addGap(9, 9, 9)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jB_book)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_MaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jB_password)
                                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jB_name)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JRadio_khac)
                                .addComponent(JRadio_Nu, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadio_Nam)
                                .addComponent(jB_Sex)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_book)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        showData();
    }//GEN-LAST:event_formComponentShown
    
    public void addEditActionListener(ActionListener log) {
        btn_edit.addActionListener(log);
    }
    
    public boolean checkRong(){
        if(txt_password.getText().equals("")||txt_name.getText().equals("")||txt_MaSV.getText().equals("") ||
            txt_email.getText().equals("") || txt_Address.getText().equals("")|| btnGroup_Sex.getSelection() == null){
                return true ;
        }
        return false ;
    }
    
    public User getUser() {
        User user = new  User();
        user.setTaiKhoan(tk);
        user.setMatKhau(txt_password.getText());
        user.setHoTen(txt_name.getText());
        user.setMaSV(txt_MaSV.getText());
        if (jRadio_Nam.isSelected()) {
            user.setGioiTinh("Nam");
        } else if (JRadio_Nu.isSelected()) {
            user.setGioiTinh("Nữ");
            }else{
                user.setGioiTinh("Khác");
            }
        user.setEmail(txt_email.getText());
        user.setDiaChi(txt_Address.getText());
        return user;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JRadio_Nu;
    private javax.swing.JRadioButton JRadio_khac;
    private javax.swing.JTable TableUsers;
    private javax.swing.ButtonGroup btnGroup_Sex;
    private javax.swing.JButton btn_edit;
    private javax.swing.JLabel jB_Sex;
    private javax.swing.JLabel jB_book;
    private javax.swing.JLabel jB_name;
    private javax.swing.JLabel jB_password;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadio_Nam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea txt_Address;
    private javax.swing.JTextField txt_MaSV;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_password;
    // End of variables declaration//GEN-END:variables

}
