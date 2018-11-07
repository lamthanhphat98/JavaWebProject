/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import boot.BootDAO;
import boot.BootDTO;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SeachBySelectAction {

    private String selectSize;
    private String selectColor;
    List<BootDTO> listProduct;

    public List<BootDTO> getListProduct() {
        return listProduct;
    }

    public void setSelectSize(String selectSize) {
        this.selectSize = selectSize;
    }

    public void setSelectColor(String selectColor) {
        this.selectColor = selectColor;
    }

    public String getSelectSize() {
        return selectSize;
    }

    public String getSelectColor() {
        return selectColor;
    }

    public SeachBySelectAction() {
    }

    public String execute() throws Exception {
        BootDAO dao = new BootDAO();
        System.out.println(selectColor);
        System.out.println(selectSize);
        listProduct = dao.getBySizeAndColor(selectSize, selectColor);
        return "success";
    }

}
