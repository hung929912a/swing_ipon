/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.impl.CategoryDaoImpl;
import dao.impl.CouponDaoImpl;
import dao.impl.DbConnection;
import dao.impl.ProductDaoImpl;
import entity.CategoryEntity;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class CategoryList extends javax.swing.JInternalFrame {

    private Connection con;
    private CategoryDaoImpl categoryDao;
    private ProductDaoImpl productDaoImpl;
    private int id;
    private List<CategoryEntity> categoryList;

    /**
     * Creates new form CategoryList
     */
    public CategoryList() {
        initComponents();
        txtError.setVisible(false);
        con = DbConnection.getConnect();
        categoryDao = new CategoryDaoImpl(con);
        productDaoImpl = new ProductDaoImpl(con);
        categoryList = categoryDao.getAll();
        loadCategory(categoryList);

    }

    private void loadCategory(List<CategoryEntity> arr) {
        //tạo model
        DefaultTableModel model = new DefaultTableModel();
        //tạo cột
        Vector cols = new Vector();
        cols.add("Mã");
        cols.add("Tên");
        model.setColumnIdentifiers(cols);
        //đọc dữ liệu
        for (CategoryEntity c : arr) {
            Vector rows = new Vector();
            rows.add(c.getId());
            rows.add(c.getName());

            model.addRow(rows);
        }
        tblCategory.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnAddCategory = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCategoryName = new javax.swing.JEditorPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtSearch = new javax.swing.JEditorPane();
        btnSearch = new javax.swing.JButton();
        txtError = new javax.swing.JLabel();

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_wrench_30px.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_delete_forever_30px_1.png"))); // NOI18N
        btnRemove.setText("Xóa");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategory);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Tên Sản Phẩm");

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_data_backup_30px.png"))); // NOI18N
        btnNew.setText("Làm Mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAddCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/icons8_add_30px.png"))); // NOI18N
        btnAddCategory.setText("Thêm\n");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtCategoryName);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Tìm Kiếm");

        jScrollPane5.setViewportView(txtSearch);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouce/search.png"))); // NOI18N
        btnSearch.setText("\n");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtError.setForeground(new java.awt.Color(255, 51, 51));
        txtError.setText("Vui Lòng Nhập Tên !");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnNew)
                        .addGap(26, 26, 26)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(txtError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRemove)
                        .addComponent(btnEdit)
                        .addComponent(btnNew)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtError)
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        loadCategory(categoryDao.search(txtSearch.getText()));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        if (txtCategoryName.getText().equals("")) {
                txtError.setVisible(true);
        } else {
            CategoryEntity category = new CategoryEntity();
            category.setName(txtCategoryName.getText());
            categoryDao.insert(category);
            txtCategoryName.setText("");
            categoryList = categoryDao.getAll();
            loadCategory(categoryList);
               txtError.setVisible(false);
        }
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtCategoryName.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        productDaoImpl.deleteByCate_id(id);
        categoryDao.deleteById(id);
        categoryList = categoryDao.getAll();
        loadCategory(categoryList);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoryMouseClicked
        int rowselect = tblCategory.getSelectedRow();
        int id = (int) tblCategory.getValueAt(rowselect, 0);
        this.id = id;
        CategoryEntity category = categoryDao.getById(id);
        txtCategoryName.setText(category.getName());
    }//GEN-LAST:event_tblCategoryMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        CategoryEntity cate = new CategoryEntity();
        cate.setName(txtCategoryName.getText());
        cate.setId(id);
        categoryDao.update(cate);
        txtCategoryName.setText("");
        categoryList = categoryDao.getAll();
        loadCategory(categoryList);
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblCategory;
    private javax.swing.JEditorPane txtCategoryName;
    private javax.swing.JLabel txtError;
    private javax.swing.JEditorPane txtSearch;
    // End of variables declaration//GEN-END:variables
}
