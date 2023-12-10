package entity.cart;

import entity.media.Media;

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
     * Functional Cohesion
     */
    public Media getMedia() {
        return this.media;
    }


    /**
     * Data Coupling
     * Functional Cohesion
     */
    public void setMedia(Media media) {
        this.media = media;
    }


    /**
     * Data Coupling
     * Functional Cohesion
     */
    public int getQuantity() {
        return this.quantity;
    }


    /**
     * Data Coupling
     * Functional Cohesion
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * Data Coupling
     * Functional Cohesion
     */
    public int getPrice() {
        return this.price;
    }


    /**
     * Data Coupling
     * Functional Cohesion
     */
    public void setPrice(int price) {
        this.price = price;
    }


    /**
     * Data Coupling
     * Functional Cohesion
     */
    @Override
    public String toString() {
        return "{"
                + " media='" + media + "'"
                + ", quantity='" + quantity + "'"
                + "}";
    }

}
