package entity.cart;

import entity.media.Media;

/**
 * Update Coupling - Cohesion:
 * Coupling và Cohesion thấp do sự dụng getter/setter cho từng thuộc tính
 */

public class CartMedia {

    private Media media;
    private int quantity;
    private int price;

    public CartMedia() {

    }

    public CartMedia(Media media, Cart cart, int quantity, int price) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }


    /**
     * Data Coupling
     */
    public Media getMedia() {
        return this.media;
    }


    /**
     * Data Coupling
     */
    public void setMedia(Media media) {
        this.media = media;
    }


    /**
     * Data Coupling
     */
    public int getQuantity() {
        return this.quantity;
    }


    /**
     * Data Coupling
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * Data Coupling
     */
    public int getPrice() {
        return this.price;
    }


    /**
     * Data Coupling
     */
    public void setPrice(int price) {
        this.price = price;
    }


    /**
     * Data Coupling
     */
    @Override
    public String toString() {
        return "{"
                + " media='" + media + "'"
                + ", quantity='" + quantity + "'"
                + "}";
    }

}
