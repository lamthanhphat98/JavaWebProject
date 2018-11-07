/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import boot.BootDTO;
import color.ColorDTO;
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
public class CartDAO {

    public boolean addToCart(CartDTO cart) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        // ResultSet rs = null;
        // List<ColorDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Insert into tbl_Cart values(?,?,?,?,?,?,?)";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, cart.getProductId());
                pstm.setString(2, cart.getProductName());
                pstm.setInt(3, cart.getQuantity());
                pstm.setDouble(4, cart.getPrice());
                pstm.setString(5, cart.getSizeName());
                pstm.setString(6, cart.getPicture());
                pstm.setString(7, cart.getUserId());
                int rs = pstm.executeUpdate();
                if (rs > 0) {
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

    public List<CartDTO> loadAllCartByUser(String userId) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<CartDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select * from tbl_Cart where userId = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, userId);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int cartId = rs.getInt("CartId");
                    int productId = rs.getInt("ProductId");
                    String productName = rs.getString("ProductName");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String sizeName = rs.getString("SizeName");
                    String picture = rs.getString("Picture");
                    String username = rs.getString("UserId");
                    CartDTO dto = new CartDTO(cartId, productId, productName, quantity, price, sizeName, picture, username);
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

//    public boolean checkCart(int productId) throws SQLException, NamingException {
//        Connection conn = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        // List<CartDTO> listProduct = new ArrayList();
//        try {
//
//            conn = DBUtil.getConnection();
//            if (conn != null) {
//                String sql = "Select * from tbl_Cart where ProductId = ?";
//                pstm = conn.prepareStatement(sql);
//                pstm.setInt(1, productId);
//                rs = pstm.executeQuery();
//                if (rs.next()) {
//                    return true;
//                }
//            }
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (pstm != null) {
//                pstm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return false;
//    }
    public List<CartDTO> getCartByProductId(int productId, String userId) throws SQLException, NamingException, InterruptedException {
        // wait(5000);
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<CartDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select * from tbl_Cart where ProductId = ? and UserId = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, productId);
                pstm.setString(2, userId);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    int cartId = rs.getInt("CartId");
                    int id = rs.getInt("ProductId");
                    String productName = rs.getString("ProductName");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String sizeName = rs.getString("SizeName");
                    String picture = rs.getString("Picture");
                    String username = rs.getString("UserId");
                    CartDTO dto = new CartDTO(id, productName, quantity, price, sizeName, picture, username);
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

    public boolean updateQuantityByProductId(int productId, int quantity, String userId) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        // ResultSet rs = null;
        // List<CartDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Update tbl_Cart set Quantity = ? where ProductId = ? and UserId = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, quantity);
                pstm.setInt(2, productId);
                pstm.setString(3, userId);
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

    public boolean deleteCartByProductId(int productId, String userId) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        // ResultSet rs = null;
        // List<CartDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Delete from tbl_Cart where ProductId = ? and UserId = ?";
                pstm = conn.prepareStatement(sql);
                // pstm.setInt(1, quantity);
                pstm.setInt(1, productId);
                pstm.setString(2, userId);
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

    public boolean deleteAllCartByUser(String userId) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        // ResultSet rs = null;
        // List<CartDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Delete from tbl_Cart where UserId = ?";
                pstm = conn.prepareStatement(sql);
                // pstm.setInt(1, quantity);
                pstm.setString(1, userId);
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

    public boolean checkQuantity(int productId, String userId) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<CartDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select * from tbl_Boots,tbl_Cart where tbl_Boots.Id=tbl_Cart.ProductId "
                        + "and tbl_Boots.Quantity >= tbl_Cart.Quantity "
                        + "and tbl_Cart.ProductId=? and tbl_Cart.UserId=?";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, productId);
                pstm.setString(2, userId);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    return true;
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
        return false;
    }

}
