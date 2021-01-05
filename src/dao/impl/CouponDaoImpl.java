/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CouponDAO;
import entity.CouponEntity;
import entity.ProductEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */

public class CouponDaoImpl implements CouponDAO<CouponEntity, String>{
    
    private Connection con;
    
    ProductDaoImpl dpro = null;

    public CouponDaoImpl(Connection con) {
        this.con = con;
        dpro = new ProductDaoImpl(con);
    }
    
    public CouponDaoImpl() {}

    @Override
    public List<CouponEntity> getAll() {
        List<CouponEntity> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from coupon");
            while(rs.next()) {
                CouponEntity c = new CouponEntity(rs.getString(1), rs.getInt(2),rs.getString(3), rs.getDouble(4),rs.getDate(5));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public CouponEntity getById(String id) {
        try {
            PreparedStatement pst = con.prepareStatement("select * from coupon where id = ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                return new CouponEntity(rs.getString(1), rs.getInt(2),rs.getString(3), rs.getDouble(4),rs.getDate(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(CouponEntity t, List<ProductEntity> listPro) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into coupon values(?,?,?,?,?)");
            pst.setString(1, t.getId());
            pst.setInt(2, t.getEm_id());
            pst.setString(3, t.getSupplier_name());
            pst.setDouble(4, t.getTotal_price());
            pst.setDate(5, t.getDate_creat());
            pst.executeUpdate();
            for(ProductEntity p: listPro) {
                p.setCou_id(t.getId());
                dpro.insert(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CouponDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(CouponEntity t, List<ProductEntity> listPro) {
        try {
            PreparedStatement pst = con.prepareStatement("update coupon set em_id=?, supplier_name=?, total_price=?, date_create=? where id = ?");
            pst.setInt(1, t.getEm_id());
            pst.setString(2, t.getSupplier_name());
            pst.setDouble(3, t.getTotal_price());
            pst.setDate(4, t.getDate_creat());
            pst.setString(5, t.getId());
            pst.executeUpdate();
            for(ProductEntity p: listPro) {
                dpro.update(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CouponDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from coupon where id = ?");
            pst.setString(1, id);
            PreparedStatement prost = con.prepareStatement("delete from product where cou_id = ?");
            prost.setString(1, id);
            prost.executeUpdate();
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<CouponEntity> search(String name) {
        List<CouponEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from coupon where supplier_name like ?");
            pst.setString(1, "%"+name+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new CouponEntity(rs.getString(1), rs.getInt(2),rs.getString(3), rs.getDouble(4),rs.getDate(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
}
