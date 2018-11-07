/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderdetail;

import cart.CartDTO;
import database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ADMIN
 */
public class OrderDetailDAO {

    public boolean addToOrderDetail(OrderDetailDTO orderDetail) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;
        // ResultSet rs = null;
        // List<ColorDTO> listProduct = new ArrayList();
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Insert into tbl_OrderDetails values(?,?,?,?)";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, orderDetail.getOrderId());
                pstm.setInt(2, orderDetail.getProductId());
                pstm.setInt(3, orderDetail.getQuantity());
                pstm.setDouble(4, orderDetail.getPrice());
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
}
