/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import cart.CartDTO;
import database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ADMIN
 */
public class UserDAO {

    public boolean addNewUser(UserDTO user) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        // ResultSet rs = null;
        // List<ColorDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Insert into tbl_User values(?,?,?,?)";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, user.getUsername());
                pstm.setString(2, user.getPassword());
                pstm.setString(3, user.getFullName());
                pstm.setString(4, user.getPassword());
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

    public boolean checkLogin(String username, String password) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        // List<CartDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select * from tbl_User where Username = ? and Password = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, username);
                pstm.setString(2, password);
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
