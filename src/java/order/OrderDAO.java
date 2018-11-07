/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import cart.CartDTO;
import database.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ADMIN
 */
public class OrderDAO {

    public boolean addToOrder(OrderDTO order) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Insert into tbl_Order values(?,?)";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, order.getUserId());
                pstm.setDate(2, order.getDate());
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

    public OrderDTO getOrderByUser(String userId) throws SQLException, NamingException, InterruptedException {
        // wait(5000);
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select top 1 OrderId from tbl_Order where UserId = ? order by OrderId DESC";
                pstm = conn.prepareStatement(sql);
                //pstm.setInt(1, productId);
                pstm.setString(1, userId);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    int orderId = rs.getInt("OrderId");
                    OrderDTO dto = new OrderDTO(orderId, userId, null);
                    return dto;
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
        return null;
    }

}
