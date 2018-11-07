/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import boot.BootDAO;
import boot.BootDTO;
import color.ColorDAO;
import color.ColorDTO;
import com.opensymphony.xwork2.ActionContext;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import size.SizeDAO;
import size.SizeDTO;

/**
 *
 * @author ADMIN
 */
public class IndexAction {

    List<BootDTO> listProduct;
    List<BootDTO> newArrivals;
    List<SizeDTO> listSize;
    List<ColorDTO> listColor;

    public List<ColorDTO> getListColor() {
        return listColor;
    }

    public List<SizeDTO> getListSize() {
        return listSize;
    }

    public List<BootDTO> getNewArrivals() {
        return newArrivals;
    }

    public List<BootDTO> getListProduct() {
        return listProduct;
    }

    public IndexAction() throws SQLException, NamingException {
        ColorDAO colorDao = new ColorDAO();
        SizeDAO sizeDao = new SizeDAO();
        listColor = colorDao.getAllColor();
        listSize = sizeDao.getAllSize();

    }

    public String execute() throws Exception {
        BootDAO dao = new BootDAO();
        listProduct = dao.getTop4Sale();
        newArrivals = dao.getNewArrivals();
        Map session = ActionContext.getContext().getSession();
        session.remove("CURRENTBOOT");
        // session.put("CURRENTUSER", "user1");
        return "success";
    }

}
