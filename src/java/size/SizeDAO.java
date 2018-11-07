/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package size;

import boot.BootDTO;
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
public class SizeDAO {

    public List<SizeDTO> getAllSize() throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<SizeDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select * from tbl_Size";
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("SizeId");
                    String name = rs.getString("SizeName");

                    SizeDTO dto = new SizeDTO(id, name);
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

    public List<SizeDTO> getAllSizeByProductName(String productName) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<SizeDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select * from tbl_Size,tbl_Boots where tbl_Size.SizeId "
                        + "= tbl_Boots.SizeId and tbl_Boots.Name = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, productName);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("SizeId");
                    String name = rs.getString("SizeName");
                    SizeDTO dto = new SizeDTO(id, name);
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

}
