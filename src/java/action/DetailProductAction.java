/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import boot.BootDAO;
import boot.BootDTO;
import cart.CartDAO;
import color.ColorDTO;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import size.SizeDAO;
import size.SizeDTO;

/**
 *
 * @author ADMIN
 */
public class DetailProductAction {

    private String bootId;
    List<BootDTO> listProduct;
    List<SizeDTO> listSize;

    public String getBootId() {
        return bootId;
    }

    public void setBootId(String bootId) {
        this.bootId = bootId;
    }

    public List<SizeDTO> getListSize() {
        return listSize;
    }

    public List<BootDTO> getListProduct() {
        return listProduct;
    }

    public DetailProductAction() {

    }

    public String execute() throws Exception {
        BootDAO dao = new BootDAO();
        Map session = ActionContext.getContext().getSession();
        int id = 0;
        if (bootId == null) {

        } else {
            id = Integer.parseInt(bootId);
        }

        if (session.get("CURRENTBOOT") != null) {
            id = (int) session.get("CURRENTBOOT");
        }
        listProduct = dao.getBootById(id);
        SizeDAO sizeDao = new SizeDAO();
        listSize = sizeDao.getAllSizeByProductName(listProduct.get(0).getName());
        return "success";
    }

}
