/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package color;

import database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import size.SizeDTO;

/**
 *
 * @author ADMIN
 */
public class ColorDAO {

    public List<ColorDTO> getAllColor() throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ColorDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select * from tbl_Color";
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ColorId");
                    String name = rs.getString("ColorName");

                    ColorDTO dto = new ColorDTO(id, name);
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
