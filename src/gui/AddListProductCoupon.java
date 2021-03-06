/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
+ơ * and open the template in the editor.
 */
package gui;

import dao.impl.CategoryDaoImpl;
import dao.impl.CouponDaoImpl;
import dao.impl.DbConnection;
import dao.impl.EmployeeDaoImpl;
import dao.impl.Pro_coupDAOImpl;
import dao.impl.ProductDaoImpl;
import entity.CategoryEntity;
import entity.CouponEntity;
import entity.EmployeeEntity;
import entity.ProductEntity;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import static dao.impl.Pro_coupDAOImpl.*;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class AddListProductCoupon extends javax.swing.JFrame {

//    public static List<ProductEntity> listPro = null;
    private CouponDaoImpl dcoup;
    private ProductDaoImpl dpro;
    private EmployeeDaoImpl demp;
    private Connection con;
    private CategoryDaoImpl dcate;
    private Pro_coupDAOImpl proCoup;

    /**
     * Creates new form AddListProductCoupon
     */
//    public AddListProductCoupon() {
//        initComponents();
//    }
    public AddListProductCoupon() {
        initComponents();
        con = DbConnection.getConnect();
        dcoup = new CouponDaoImpl(con);
        dpro = new ProductDaoImpl(con);
        demp = new EmployeeDaoImpl(con);
        dcate = new CategoryDaoImpl(con);
        this.loadCate();
        this.loadPro();
    }

    private void loadCate() {
        for (CategoryEntity c : dcate.getAll()) {
            categories.addItem(c);
        }
    }

    private void loadPro() {
        DefaultTableModel model = new DefaultTableModel();
        Vector cols = new Vector();
        cols.add("mã");
        cols.add("Tên sản phẩm");
        cols.add("Mã danh mục");
        cols.add("Số lượng");
        cols.add("Giá");
        cols.add("Mã đơn nhập");
        model.setColumnIdentifiers(cols);
        for (ProductEntity p : listPro) {
            Vector rows = new Vector();
            rows.add(p.getId());
            rows.add(p.getName());
            rows.add(p.getCate_id());
            rows.add(p.getOld_count());
            rows.add(p.getPrice());
            rows.add(p.getCou_id());
            model.addRow(rows);
        }
        proTable.setModel(model);
    }

    private void loadPage() {
        name.setText("");
        count.setText("");
        price.setText("");
        msg.setText("");
        row.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        proTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        name = new javax.swing.JEditorPane();
        categories = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        count = new javax.swing.JEditorPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        price = new javax.swing.JEditorPane();
        add = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        row = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        loadpage = new javax.swing.JButton();

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_wrench_30px.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_delete_forever_30px_1.png"))); // NOI18N
        delete.setText("Xóa");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        proTable.setModel(new javax.swing.table.DefaultTableModel(
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
        proTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(proTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Tên Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Loại Sản Phẩm");

        jScrollPane2.setViewportView(name);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Số Lượng");

        jScrollPane3.setViewportView(count);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Đơn Giá");

        jScrollPane4.setViewportView(price);

        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_add_30px.png"))); // NOI18N
        add.setText("Thêm\n");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_ok_30px.png"))); // NOI18N
        btnSave.setText("Đóng");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        msg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 0, 0));

        loadpage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_replay_30px.png"))); // NOI18N
        loadpage.setText("Load Page");
        loadpage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadpageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(row, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(categories, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadpage, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(delete))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(row, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categories, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 57, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                .addComponent(jScrollPane4))
                            .addComponent(loadpage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        this.setVisible(false);

    }//GEN-LAST:event_btnSaveActionPerformed

    private void proTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proTableMouseClicked
        int row = proTable.getSelectedRow();
        msg.setText("");
        this.row.setText(String.valueOf(proTable.getSelectedRow()));
        name.setText((String) proTable.getValueAt(row, 1));
        for (int i = 0; i < categories.getItemCount(); i++) {
            if (categories.getItemAt(i).getId() == (int) proTable.getValueAt(row, 2)) {
                categories.setSelectedIndex(i);
            }
        }
        count.setText(String.valueOf(proTable.getValueAt(row, 3)));
        price.setText(String.valueOf(proTable.getValueAt(row, 4)));
    }//GEN-LAST:event_proTableMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if (row.getText().equals("")) {
            msg.setText("Vui lòng chọn sản phẩm!");
        } else {
            if (name.getText().equals("") || count.getText().equals("") || price.getText().equals("")) {
                msg.setText("Điền đầy đủ thông tin!");
            } else {
                int i = Integer.parseInt(row.getText());
                listPro.get(i).setName(name.getText());
                listPro.get(i).setOld_count(Integer.parseInt(count.getText()));
                CategoryEntity cate = categories.getItemAt(categories.getSelectedIndex());
                listPro.get(i).setCate_id(cate.getId());
                listPro.get(i).setPrice(Double.parseDouble(price.getText()));
                this.loadPro();
                this.loadPage();
            }
        }

    }//GEN-LAST:event_updateActionPerformed

    private void loadpageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadpageActionPerformed
        this.loadPage();
        this.loadPro();
    }//GEN-LAST:event_loadpageActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if (name.getText().equals("") || count.getText().equals("") || price.getText().equals("")) {
            msg.setText("Điền đầy đủ thông tin!");
        } else {
            CategoryEntity cate = categories.getItemAt(categories.getSelectedIndex());
            listPro.add(new ProductEntity(name.getText(), cate.getId(), Integer.parseInt(count.getText()), Double.parseDouble(price.getText())));
            this.loadPro();
            this.loadPage();
        }
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (row.getText().equals("")) {
            msg.setText("Vui lòng chọn sản phẩm cần xóa!");
        } else {
            int opcion = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa?", "CẢNH BÁO!", JOptionPane.YES_NO_OPTION);
            if (opcion == 0) {
                ProductEntity pro = listPro.get(Integer.parseInt(row.getText()));
                if(pro.getId()==0) {
                    listPro.remove(Integer.parseInt(row.getText()));
                } else {
                    dpro.deleteById(pro.getId());
                    listPro.remove(Integer.parseInt(row.getText()));
                }
                this.loadPro();
                this.loadPage();
            }
        }
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<CategoryEntity> categories;
    private javax.swing.JEditorPane count;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton loadpage;
    private javax.swing.JLabel msg;
    private javax.swing.JEditorPane name;
    private javax.swing.JEditorPane price;
    private javax.swing.JTable proTable;
    private javax.swing.JLabel row;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
