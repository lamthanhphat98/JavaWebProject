/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package color;

/**
 *
 * @author ADMIN
 */
public class ColorDTO {

    private int colorId;
    private String colorName;

    public ColorDTO(int colorId, String colorName) {
        this.colorId = colorId;
        this.colorName = colorName;
    }

    public ColorDTO() {
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public int getColorId() {
        return colorId;
    }

}
