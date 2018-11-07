/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boot;

import database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ADMIN
 */
public class BootDAO {

    public List<BootDTO> getTop4Sale() throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<BootDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select top 4 * from tbl_Boots where Sale = 1 order by ID DESC";
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    double price = rs.getDouble("Price");;
                    String picture = rs.getString("Picture");;
                    int sizeId = rs.getInt("SizeId");
                    int colorId = rs.getInt("ColorId");
                    boolean Sale = rs.getBoolean("Sale");
                    boolean Sex = rs.getBoolean("Sex");
                    BootDTO dto = new BootDTO(id, name, price, picture, sizeId, colorId, Sale, Sex);
                    //String name = rs.getString("roleName");
                    listProduct.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listProduct;
    }

    public List<BootDTO> getNewArrivals() throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<BootDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select top 4 * from tbl_Boots order by Id DESC";
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    double price = rs.getDouble("Price");;
                    String picture = rs.getString("Picture");;
                    int sizeId = rs.getInt("SizeId");
                    int colorId = rs.getInt("ColorId");
                    boolean Sale = rs.getBoolean("Sale");
                    boolean Sex = rs.getBoolean("Sex");
                    BootDTO dto = new BootDTO(id, name, price, picture, sizeId, colorId, Sale, Sex);
                    //String name = rs.getString("roleName");
                    listProduct.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listProduct;
    }

    public int getQuantityById(int Id) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        //List<BootDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select Quantity from tbl_Boots where Id = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, Id);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    int quantity = rs.getInt("Quantity");
                    return quantity;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return 0;
    }

    public List<BootDTO> getBootById(int Id) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<BootDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select * from tbl_Boots where Id = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, Id);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    double price = rs.getDouble("Price");;
                    String picture = rs.getString("Picture");;
                    int sizeId = rs.getInt("SizeId");
                    int colorId = rs.getInt("ColorId");
                    boolean Sale = rs.getBoolean("Sale");
                    boolean Sex = rs.getBoolean("Sex");
                    int quantity = rs.getInt("Quantity");
                    BootDTO dto = new BootDTO(id, name, price, picture, sizeId, colorId, Sale, Sex, quantity);
                    //String name = rs.getString("roleName");
                    listProduct.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listProduct;
    }

    public List<BootDTO> getBySizeAndColor(String size, String color) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<BootDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select * from tbl_Boots where SizeId = ? and ColorId = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, Integer.parseInt(size));
                pstm.setInt(2, Integer.parseInt(color));
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    double price = rs.getDouble("Price");;
                    String picture = rs.getString("Picture");;
                    int sizeId = rs.getInt("SizeId");
                    int colorId = rs.getInt("ColorId");
                    boolean Sale = rs.getBoolean("Sale");
                    boolean Sex = rs.getBoolean("Sex");
                    BootDTO dto = new BootDTO(id, name, price, picture, sizeId, colorId, Sale, Sex);
                    //String name = rs.getString("roleName");
                    listProduct.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listProduct;
    }

    public int getSizeByName(String size) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        //List<BootDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select SizeId from tbl_Size where SizeName = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, size);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    int sizeId = rs.getInt("SizeId");
                    return sizeId;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return 0;
    }

    public int getColorByName(String color) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        //List<BootDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select ColorId from tbl_Color where ColorName = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, color);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("ColorId");
                    return id;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return 0;
    }

    public boolean updateQuantityBoot(int productId, int quantity) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        // ResultSet rs = null;
        // List<CartDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Update tbl_Boots set Quantity = ? where Id = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, quantity);
                pstm.setInt(2, productId);
                //pstm.setString(3, userId);
                int result = pstm.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {

            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

}
