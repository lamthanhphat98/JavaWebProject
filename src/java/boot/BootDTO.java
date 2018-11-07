/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boot;

/**
 *
 * @author ADMIN
 */
public class BootDTO {

    private int id;
    private String name;
    private double price;
    private String picture;
    private int sizeId;
    private int colorId;
    private boolean Sale;
    private boolean Sex;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BootDTO(int id, String name, double price, String picture, int sizeId, int colorId, boolean Sale, boolean Sex, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.sizeId = sizeId;
        this.colorId = colorId;
        this.Sale = Sale;
        this.Sex = Sex;
        this.quantity = quantity;
    }

    public BootDTO(int id, String name, double price, String picture, int sizeId, int colorId, boolean Sale, boolean Sex) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.sizeId = sizeId;
        this.colorId = colorId;
        this.Sale = Sale;
        this.Sex = Sex;
    }

    public BootDTO() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return the sizeId
     */
    public int getSizeId() {
        return sizeId;
    }

    /**
     * @param sizeId the sizeId to set
     */
    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    /**
     * @return the colorId
     */
    public int getColorId() {
        return colorId;
    }

    /**
     * @param colorId the colorId to set
     */
    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    /**
     * @return the Sale
     */
    public boolean isSale() {
        return Sale;
    }

    /**
     * @param Sale the Sale to set
     */
    public void setSale(boolean Sale) {
        this.Sale = Sale;
    }

    /**
     * @return the Sex
     */
    public boolean isSex() {
        return Sex;
    }

    /**
     * @param Sex the Sex to set
     */
    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }

}
