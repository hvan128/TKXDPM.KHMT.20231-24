package entity.order;

import entity.media.Media;

public class OrderMedia {

    private Media media;
    private int price;
    private int quantity;

    public OrderMedia(Media media, int quantity, int price) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }


    /**
     * Data Coupling
     */
    @Override
    public String toString() {
        return "{" +
                "  media='" + media + "'" +
                ", quantity='" + quantity + "'" +
                ", price='" + price + "'" +
                "}";
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
     * Data coupling
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

}
