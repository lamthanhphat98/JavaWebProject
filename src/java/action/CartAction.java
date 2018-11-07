/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import boot.BootDAO;
import boot.BootDTO;
import cart.CartDAO;
import cart.CartDTO;
import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import order.OrderDAO;
import order.OrderDTO;
import orderdetail.OrderDetailDAO;
import orderdetail.OrderDetailDTO;

/**
 *
 * @author ADMIN
 */
public class CartAction {

    private String selectSize;
    private String name;
    private String price;
    private String picture;
    List<CartDTO> listCart;
    private String bootId;
    private String quantity;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBootId() {
        return bootId;
    }

    public void setBootId(String bootId) {
        this.bootId = bootId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CartDTO> getListCart() {
        return listCart;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSelectSize(String selectSize) {
        this.selectSize = selectSize;
    }

    public String getSelectSize() {
        return selectSize;
    }

    public CartAction() {
    }

    public String execute() throws Exception {
        CartDAO dao = new CartDAO();
        Map session = ActionContext.getContext().getSession();
        int productId = Integer.parseInt(bootId);
        double realPrice = Double.parseDouble(price);

        session.put("CURRENTBOOT", productId);
        //System.out.println(selectSize);
        String userId = (String) session.get("CURRENTUSER");
        if (!dao.getCartByProductId(productId, userId).isEmpty()) {
            if (selectSize.equals("-1")) {
                session.put("ERROR", "Please choose size");
                return "fail";
            } else {
                int Quantity = dao.getCartByProductId(productId, userId).get(0).getQuantity();
                Quantity = Quantity + 1;
                if (dao.updateQuantityByProductId(productId, Quantity, userId)) {
                    session.remove("ERROR");
                    session.remove("CURRENTBOOT");
                    return "success";
                }
            }
        } else {
            CartDTO cart = new CartDTO(productId, name, 1, realPrice, selectSize, picture, userId);
            if (selectSize.equals("-1")) {
                session.put("ERROR", "Please choose size");
                return "fail";
            } else {
                if (dao.addToCart(cart)) {
                    session.remove("ERROR");
                    session.remove("CURRENTBOOT");
                    return "success";
                }
            }

        }

        return "fail";
    }

    public String viewCart() throws SQLException, NamingException, InterruptedException {
        CartDAO dao = new CartDAO();
        OrderDAO orderDao = new OrderDAO();
        Map session = ActionContext.getContext().getSession();
        String userId = (String) session.get("CURRENTUSER");
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        listCart = dao.loadAllCartByUser(userId);
        if (listCart.size() != 0) {
            if (session.get("CURRENTORDER") == null) {
                OrderDTO order = new OrderDTO(userId, date);
                orderDao.addToOrder(order);
                OrderDTO oldOrder = orderDao.getOrderByUser(userId);
                session.put("CURRENTORDER", oldOrder);
            }
        }
        return "success";
    }

    public String deleteCart() throws SQLException, NamingException {
        CartDAO dao = new CartDAO();
        Map session = ActionContext.getContext().getSession();
        String userId = (String) session.get("CURRENTUSER");
        int productId = Integer.parseInt(bootId);
        if (dao.deleteCartByProductId(productId, userId)) {
            return "success";
        }
        return "fail";
    }

    public String plus() throws SQLException, NamingException {
        CartDAO dao = new CartDAO();
        int productId = Integer.parseInt(bootId);
        Map session = ActionContext.getContext().getSession();
        String userId = (String) session.get("CURRENTUSER");
        int Quantity = Integer.parseInt(quantity);
        Quantity = Quantity + 1;
        if (dao.updateQuantityByProductId(productId, Quantity, userId)) {
            return "success";
        }
        return "fail";
    }

    public String minus() throws SQLException, NamingException {
        CartDAO dao = new CartDAO();
        Map session = ActionContext.getContext().getSession();
        String userId = (String) session.get("CURRENTUSER");
        int productId = Integer.parseInt(bootId);
        int Quantity = Integer.parseInt(quantity);
        if (Quantity == 0) {
            return "fail";
        }
        Quantity = Quantity - 1;
        if (dao.updateQuantityByProductId(productId, Quantity, userId)) {
            return "success";
        }
        return "fail";
    }

    public String checkout() throws SQLException, NamingException, InterruptedException {
        CartDAO dao = new CartDAO();
        BootDAO bootDao = new BootDAO();
        OrderDAO orderdao = new OrderDAO();
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        OrderDetailDAO orderdetail = new OrderDetailDAO();
        Map session = ActionContext.getContext().getSession();
        String userId = (String) session.get("CURRENTUSER");
        listCart = dao.loadAllCartByUser(userId);
        for (CartDTO dto : listCart) {
            //System.out.println(dto.getCartId());
            //  OrderDTO orderdto = new OrderDTO(dto.getCartId(), userId, date);
            if (!dao.checkQuantity(dto.getProductId(), userId)) {
                session.put("ERRORCHECKOUT", "So luong san pham khong con du cho ban mua");
                return "fail";
            }
        }
        session.remove("ERRORCHECKOUT");
        for (CartDTO dto : listCart) {
            //System.out.println(dto.getCartId());
            OrderDTO orderdto = orderdao.getOrderByUser(userId);
            if (orderdto != null) {
                OrderDetailDTO detail = new OrderDetailDTO(orderdto.getOrderId(), dto.getProductId(), dto.getQuantity(), dto.getPrice() * dto.getQuantity());
                orderdetail.addToOrderDetail(detail);
                int finalQuantity = bootDao.getQuantityById(dto.getProductId()) - dto.getQuantity();
                bootDao.updateQuantityBoot(dto.getProductId(), finalQuantity);
            } else {
                return "fail";
            }

        }
        if (dao.deleteAllCartByUser(userId)) {
            session.remove("CURRENTORDER");
            return "success";
        }
        return "fail";
    }

}
