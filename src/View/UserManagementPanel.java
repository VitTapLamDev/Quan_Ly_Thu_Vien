/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DAO;
import Model.User;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class UserManagementPanel extends javax.swing.JPanel {
    
    private formAdmin formAdmin;
    
    public UserManagementPanel() {
        initComponents();
    }
  
    public void showData(String maSV){
        try {
            TableUsers.removeAll();
            String[] arr = {"Tài Khoản", "Mật Khẩu ", "Mã SV", "Họ Tên", "Email", "Giới Tính", "Địa Chỉ"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            Connection connection = DAO.getConnection();
            String querry = "SELECT [tenDangNhap], [matKhau], [maSV], [hoTen], [email] ,[gioiTinh], [diaChi]"
                    + " FROM [dbo].[users]" + "WHERE [ItAdmin]=0 AND MaSV LIKE '%"+maSV+"%'" + "ORDER BY maSV";
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector vector = new Vector();
                vector.add(rs.getString("tenDangNhap"));
                vector.add(rs.getString("MatKhau"));
                vector.add(rs.getString("MaSV"));
                vector.add(rs.getString("hoTen"));
                vector.add(rs.getString("email"));
                vector.add(rs.getString("gioitinh"));
                vector.add(rs.getString("diachi"));
                model.addRow(vector);
            }
            TableUsers.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(BookManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup_Sex = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jB_account = new javax.swing.JLabel();
        jB_password = new javax.swing.JLabel();
        jB_name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jB_Sex = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_account = new javax.swing.JTextField();
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
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jB_book = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableUsers = new javax.swing.JTable();
        jB_search = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jB_account.setText("Tài Khoản: ");

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

        btn_add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhNen/Icon/Add-icon-18.png"))); // NOI18N
        btn_add.setText("Thêm");

        btn_edit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhNen/Icon/Actions-document-edit-icon.png"))); // NOI18N
        btn_edit.setText("Sửa");

        btn_delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhNen/Icon/Actions-list-remove-user-icon.png"))); // NOI18N
        btn_delete.setText("Xóa");

        btn_reset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhNen/Icon/refresh.png"))); // NOI18N
        btn_reset.setText("Làm Mới");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_reset)
                .addGap(18, 18, 18)
                .addComponent(btn_add)
                .addGap(18, 18, 18)
                .addComponent(btn_edit)
                .addGap(18, 18, 18)
                .addComponent(btn_delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jB_book.setText("Quản Lý Bạn Đọc:");

        TableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tài Khoản", "Mật Khẩu", "Mã SV", "Họ Tên", "Giới Tính", "Email", "Địa Chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jB_account)
                                    .addComponent(jB_name)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_MaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(txt_email)
                                        .addGap(85, 85, 85))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_account)
                                                    .addComponent(txt_name))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jB_password)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jB_Sex)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addComponent(jRadio_Nam)
                                .addGap(18, 18, 18)
                                .addComponent(JRadio_Nu)
                                .addGap(18, 18, 18)
                                .addComponent(JRadio_khac)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jB_book)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_account)
                    .addComponent(jB_password)
                    .addComponent(txt_account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_name)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_MaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jB_Sex)
                            .addComponent(jRadio_Nam)
                            .addComponent(JRadio_Nu)
                            .addComponent(JRadio_khac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_book)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jB_search.setText("Tìm Kiếm Bạn Đọc: ");

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhNen/Icon/search-icon.png"))); // NOI18N
        btn_search.setText("Tìm Kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jB_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_search)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_search)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        showData("");
    }//GEN-LAST:event_formComponentShown
    
    public void addResetActionListener(ActionListener log) {
        btn_add.addActionListener(log);
    }
    
    public void addAddActionListener(ActionListener log) {
        btn_add.addActionListener(log);
    }
    public void addSearchActionListener(ActionListener log) {
        btn_search.addActionListener(log);
    }
    public void addEditActionListener(ActionListener log) {
        btn_edit.addActionListener(log);
    }
    public void addDeleteActionListener(ActionListener log) {
        btn_delete.addActionListener(log);
    }
    public void addClickTable (MouseListener log){
        TableUsers.addMouseListener(log); 
    }
    
    public String getSearch(){
        return txt_search.getText();
    }
    
    public String getUserTable(){
        return (String) TableUsers.getValueAt(TableUsers.getSelectedRow(), 2);
    }
    
    public User getUser() {
        User user = new  User();
        user.setTaiKhoan(txt_account.getText());
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
    
    public void setUser(User User) {
        txt_account.setText(User.getTaiKhoan());
                txt_password.setText(User.getMatKhau());
                txt_MaSV.setText(User.getMaSV());
                txt_name.setText(User.getHoTen());
                txt_Address.setText(User.getDiaChi());
                txt_email.setText(User.getEmail());
                switch (User.getGioiTinh()) {
                    case "Nam":
                        jRadio_Nam.doClick();
                        break;
                    case "Nữ":
                        JRadio_Nu.doClick();
                        break;
                    default:
                        JRadio_khac.doClick();
                        break;
                }
    }
    
    
    public boolean checkRong(){
        if(txt_account.getText().equals("") ||txt_password.getText().equals("")||txt_name.getText().equals("")||txt_MaSV.getText().equals("") ||
            txt_email.getText().equals("") || txt_Address.getText().equals("")|| btnGroup_Sex.getSelection() == null){
                return true ;
        }
        return false ;
    }
    
    public void reset(){
        txt_search.setText("");
        txt_account.setText("");
        txt_password.setText("");
        txt_MaSV.setText("");
        txt_name.setText("");
        txt_Address.setText("");
        txt_email.setText("");
        btnGroup_Sex.clearSelection();
      }
    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        reset();
        showData("");
    }//GEN-LAST:event_btn_resetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JRadio_Nu;
    private javax.swing.JRadioButton JRadio_khac;
    private javax.swing.JTable TableUsers;
    private javax.swing.ButtonGroup btnGroup_Sex;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jB_Sex;
    private javax.swing.JLabel jB_account;
    private javax.swing.JLabel jB_book;
    private javax.swing.JLabel jB_name;
    private javax.swing.JLabel jB_password;
    private javax.swing.JLabel jB_search;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadio_Nam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea txt_Address;
    private javax.swing.JTextField txt_MaSV;
    private javax.swing.JTextField txt_account;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables


}
