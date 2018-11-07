/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package size;

/**
 *
 * @author ADMIN
 */
public class SizeDTO {

    private int sizeId;
    private String sizeName;

    public SizeDTO(int sizeId, String sizeName) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
    }

    public SizeDTO() {
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public int getSizeId() {
        return sizeId;
    }

}
