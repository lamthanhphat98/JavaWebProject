/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

/**
 *
 * @author ADMIN
 */
public class CartDTO {

    private int cartId;
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    private String sizeName;
    private String picture;
    private String userId;

    public CartDTO(int cartId, int productId, String productName, int quantity, double price, String sizeName, String picture, String userId) {
        this.cartId = cartId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.sizeName = sizeName;
        this.picture = picture;
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public CartDTO() {
    }

    public CartDTO(int productId, String productName, int quantity, double price, String sizeName, String picture, String userId) {

        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.sizeName = sizeName;
        this.picture = picture;
        this.userId = userId;
    }

    /**
     * @return the cartId
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * @param cartId the cartId to set
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
     * @return the sizeName
     */
    public String getSizeName() {
        return sizeName;
    }

    /**
     * @param sizeName the sizeName to set
     */
    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
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

}
