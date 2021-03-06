/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.impl.DbConnection;
import dao.impl.Em_RoleDaoImpl;
import dao.impl.EmployeeDaoImpl;
import dao.impl.RoleDaoImpl;
import entity.Em_RoleEntity;
import entity.EmployeeEntity;
import entity.RoleEntity;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class AccountList extends javax.swing.JInternalFrame {

    /**
     * Creates new form AccountList
     */
    private EmployeeDaoImpl demp;
    private Connection con;
    private Em_RoleDaoImpl der;
    private RoleDaoImpl drole;

    public AccountList() {
        initComponents();
        con = DbConnection.getConnect();
        demp = new EmployeeDaoImpl(con);
        der = new Em_RoleDaoImpl(con);
        drole = new RoleDaoImpl(con);
        this.loadAccountList();
        this.loadRole();
    }

    private void loadRole() {
        Vector data = new Vector();
        int index = 0;
        for (int i = 0; i < drole.getAll().size(); i++) {
            data.addElement(drole.getAll().get(i).getName());
            if (drole.getAll().get(i).getName().equals("EMPLOYEE")) {
                index = i;
            }
        }
        role.setListData(data);
        role.setSelectedIndex(index);
    }

    private void loadAccountList() {
        DefaultTableModel model = new DefaultTableModel();
        Vector colums = new Vector();
        colums.add("mã");
        colums.add("Tên đầy đủ");
        colums.add("tên người dùng");
        colums.add("mật khẩu");
        colums.add("trạng thái");
        colums.add("quyền");
        model.setColumnIdentifiers(colums);
        for (EmployeeEntity e : demp.getAll()) {
            Vector rows = new Vector();
            rows.add(e.getId());
            rows.add(e.getFullname());
            rows.add(e.getUsername());
            rows.add(e.getPassword());
            rows.add(e.isStatus());
            String role = "";
            for (Em_RoleEntity er : der.getByUser_id(e.getId())) {
                role += drole.getById(er.getRole_id()).getName() + " ";
            }
            rows.add(role);
            model.addRow(rows);
        }
        tableAccountList.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        tableAccountList = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        addEmployee = new javax.swing.JButton();
        searchEm = new javax.swing.JButton();
        update = new javax.swing.JButton();
        fullname = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        status = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        password1 = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        role = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        em_id = new javax.swing.JLabel();
        deleteEmployee1 = new javax.swing.JButton();
        close = new javax.swing.JButton();
        btnLoadPage = new javax.swing.JButton();

        tableAccountList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableAccountList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAccountListMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tableAccountList);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Full Name");

        addEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_add_30px.png"))); // NOI18N
        addEmployee.setText("Thêm\n");
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });

        searchEm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/search.png"))); // NOI18N
        searchEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmActionPerformed(evt);
            }
        });

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_refresh_30px.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("UserName");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Status");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Password");

        msg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 0, 0));

        status.setText("true/false");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Password again");

        jScrollPane1.setViewportView(role);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Role");

        deleteEmployee1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_delete_forever_30px_1.png"))); // NOI18N
        deleteEmployee1.setText("Xóa");
        deleteEmployee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployee1ActionPerformed(evt);
            }
        });

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_delete_30px_1.png"))); // NOI18N
        close.setText("Khóa");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        btnLoadPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_data_backup_30px.png"))); // NOI18N
        btnLoadPage.setText("Làm Mới");
        btnLoadPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadPageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(em_id, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(status)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchEm, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteEmployee1)
                                .addGap(18, 18, 18)
                                .addComponent(close)
                                .addGap(18, 18, 18)
                                .addComponent(update)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoadPage))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addEmployee)
                            .addComponent(update)
                            .addComponent(deleteEmployee1)
                            .addComponent(close)
                            .addComponent(btnLoadPage, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(searchEm, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(msg, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(em_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(password)
                                .addGap(1, 1, 1)))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status))
                .addGap(46, 46, 46)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchEmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmActionPerformed
        String name = JOptionPane.showInputDialog(this, "Mời bạn nhập fullname tên cần tìm?");
        DefaultTableModel model = new DefaultTableModel();
        Vector colums = new Vector();
        colums.add("mã");
        colums.add("Tên đầy đủ");
        colums.add("tên người dùng");
        colums.add("mật khẩu");
        colums.add("trạng thái");
        colums.add("quyền");
        model.setColumnIdentifiers(colums);
        for (EmployeeEntity e : demp.search(name)) {
            Vector rows = new Vector();
            rows.add(e.getId());
            rows.add(e.getFullname());
            rows.add(e.getUsername());
            rows.add(e.getPassword());
            rows.add(e.isStatus());
            String role = "";
            for (Em_RoleEntity er : der.getByUser_id(e.getId())) {
                role += drole.getById(er.getRole_id()).getName() + " ";
            }
            rows.add(role);
            model.addRow(rows);
        }
        tableAccountList.setModel(model);


    }//GEN-LAST:event_searchEmActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
        EmployeeEntity em = new EmployeeEntity();
        boolean checkUserExit = false;
        for (EmployeeEntity m : demp.getAll()) {
            if (m.getUsername().equals(username.getText())) {
                checkUserExit = true;
                break;
            }
        }
        if (checkUserExit) {
            msg.setText("Đã tồn tại username!");
        } else {
            if (fullname.getText().equals("") || username.getText().equals("") || password.getText().equals("") || password1.getText().equals("")) {
                msg.setText("Vui lòng điền đầy đủ thông tin!");
            } else {
                if (password.getText().equals(password1.getText())) {
                    System.out.println();
                    if (this.validateUserName(username.getText())) {
                        if (this.validateUserName(password.getText())) {
                            em.setFullname(fullname.getText());
                            em.setUsername(username.getText());
                            em.setPassword(password.getText());
                            if (status.isSelected()) {
                                em.setStatus(true);
                            } else {
                                em.setStatus(false);
                            }
                            msg.setText("");
                            demp.insert(em);
                            int id = demp.findByUsername(username.getText()).getId();
                            List<Em_RoleEntity> list = new ArrayList<>();
                            int[] selectedIx = role.getSelectedIndices();
                            for (int i = 0; i < selectedIx.length; i++) {
                                Object item = role.getModel().getElementAt(selectedIx[i]);
                                for (RoleEntity r : drole.getAll()) {
                                    if (item.equals(r.getName())) {
                                        list.add(new Em_RoleEntity(id, r.getId()));
                                    }
                                }
                            }
                            der.insert(list);
                            this.loadPage();
                            this.loadAccountList();
                        } else {
                            msg.setText("Password phải từ 4 ký tự là chữ hoặc số Không ký tự đặc biệt!");
                        }
                    } else {
                        msg.setText("Username phải từ 4 ký tự là chữ hoặc số Không ký tự đặc biệt!");
                    }

                } else {
                    msg.setText("Nhập lại mật khẩu không đúng!");
                }
            }
        }

    }//GEN-LAST:event_addEmployeeActionPerformed

    private boolean validateUserName(String username) {
        String regex = "\\w{4,}";
        return username.matches(regex);
    }

    private void loadPage() {
        em_id.setText("");
        fullname.setText("");
        username.setText("");
        password.setText("");
        password1.setText("");
        msg.setText("");
    }

    private void fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullnameActionPerformed

    private void tableAccountListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAccountListMouseClicked
        int index = tableAccountList.getSelectedRow();
        int id = (Integer) tableAccountList.getValueAt(index, 0);
        EmployeeEntity e = demp.getById(id);
        fullname.setText(e.getFullname());
        username.setText(e.getUsername());
        password.setText(e.getPassword());
        password1.setText(e.getPassword());
        status.setSelected(e.isStatus());
        em_id.setText(String.valueOf(e.getId()));
        List<Integer> role_name = new ArrayList<>();
        for (Em_RoleEntity em : der.getByUser_id(id)) {
            String r = drole.getById(em.getRole_id()).getName();
            for (int i = 0; i < role.getModel().getSize(); i++) {
                if (role.getModel().getElementAt(i).equals(r)) {
                    role_name.add(i);
                }
            }
        }
        int[] primitive = role_name.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        role.setSelectedIndices(primitive);
    }//GEN-LAST:event_tableAccountListMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if (em_id.getText().equals("")) {
            msg.setText("Vui lòng chọn nhân viên!");
        } else {
            EmployeeEntity em = demp.getById(Integer.parseInt(em_id.getText()));
            boolean checkUserExit = false;
            if (!em.getUsername().equals(username.getText())) {
                for (EmployeeEntity m : demp.getAll()) {
                    if (m.getUsername().equals(username.getText())) {
                        checkUserExit = true;
                        break;
                    }
                }
            }
            if (checkUserExit) {
                msg.setText("Đã tồn tại username!");
            } else {
                if (fullname.getText().equals("") || username.getText().equals("") || password.getText().equals("") || password1.getText().equals("")) {
                    msg.setText("Vui lòng điền đầy đủ thông tin!");
                } else {
                    if (password.getText().equals(password1.getText())) {
                        if (this.validateUserName(username.getText())) {
                            if (this.validateUserName(password.getText())) {
                                em.setId(Integer.parseInt(em_id.getText()));
                                em.setFullname(fullname.getText());
                                em.setUsername(username.getText());
                                em.setPassword(password.getText());
                                if (status.isSelected()) {
                                    em.setStatus(true);
                                } else {
                                    em.setStatus(false);
                                }
                                msg.setText("");
                                em_id.setText("");
                                demp.update(em);
                                List<Em_RoleEntity> list = new ArrayList<>();
                                int[] selectedIx = role.getSelectedIndices();
                                for (int i = 0; i < selectedIx.length; i++) {
                                    Object item = role.getModel().getElementAt(selectedIx[i]);
                                    for (RoleEntity r : drole.getAll()) {
                                        if (item.equals(r.getName())) {
                                            list.add(new Em_RoleEntity(em.getId(), r.getId()));
                                        }
                                    }
                                }
                                der.update(list);
                                this.loadPage();
                                this.loadAccountList();
                            } else {
                                msg.setText("Password phải từ 4 ký tự là chữ hoặc số Không ký tự đặc biệt!");
                            }
                        } else {
                            msg.setText("Username phải từ 4 ký tự là chữ hoặc số Không ký tự đặc biệt!");
                        }

                    } else {
                        msg.setText("Nhập lại mật khẩu không đúng!");
                    }
                }
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteEmployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployee1ActionPerformed
        if (em_id.getText().equals("")) {
            msg.setText("Vui lòng chọn nhân viên!");
        } else {
            try {
                FormMain formMain = new FormMain();

                if (formMain.em.getId() == Integer.parseInt(em_id.getText())) {
                    msg.setText("Không được xóa tài khoản đang đăng nhập!");
                } else {
                    int opcion = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa?", "CẢNH BÁO!", JOptionPane.YES_NO_OPTION);
                    if (opcion == 0) {
                        EmployeeEntity em = demp.getById(Integer.parseInt(em_id.getText()));
                        der.deleteAll(em.getId());
                        demp.deleteById(em.getId());
                        msg.setText("");
                        em_id.setText("");
                        this.loadPage();
                        this.loadAccountList();
                    }

                }
            } catch (URISyntaxException ex) {
                Logger.getLogger(AccountList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteEmployee1ActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        if (em_id.getText().equals("")) {
            msg.setText("Vui lòng chọn nhân viên!");
        } else {
            EmployeeEntity em = demp.getById(Integer.parseInt(em_id.getText()));
            em.setStatus(false);
            em_id.setText("");
            demp.update(em);
            this.loadPage();
            this.loadAccountList();
        }
    }//GEN-LAST:event_closeActionPerformed

    private void btnLoadPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadPageActionPerformed
        this.loadPage();
    }//GEN-LAST:event_btnLoadPageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployee;
    private javax.swing.JButton btnLoadPage;
    private javax.swing.JButton close;
    private javax.swing.JButton deleteEmployee1;
    private javax.swing.JLabel em_id;
    private javax.swing.JTextField fullname;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel msg;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password1;
    private javax.swing.JList<String> role;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton searchEm;
    private javax.swing.JCheckBox status;
    private javax.swing.JTable tableAccountList;
    private javax.swing.JButton update;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
