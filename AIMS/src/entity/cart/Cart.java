package entity.cart;

import common.exception.MediaNotAvailableException;
import entity.media.Media;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * SOLID:
 * Việc tách Cart và CartMedia ra thành 2 lớp đảm bảo các lớp thực hiện đúng 1 chức năng
 */

public class Cart {

    private static Cart cartInstance;
    private List<CartMedia> lstCartMedia;


    private Cart() {
        lstCartMedia = new ArrayList<>();
    }

    /**
     * Data Coupling
     * Functional Cohesion
     */
    public static Cart getCart() {
        if (cartInstance == null) cartInstance = new Cart();
        return cartInstance;
    }

    /**
     *  Data Coupling
     *  Functional Cohesion
     */
    public void addCartMedia(CartMedia cm) {
        lstCartMedia.add(cm);
    }


    /**
     * Stamp Coupling
     * Functional Cohesion
     */
    public void removeCartMedia(CartMedia cm) {
        lstCartMedia.remove(cm);
    }


    /**
     * Data Coupling
     * Functional Cohesion
     */
    public List<CartMedia> getListMedia() {
        return lstCartMedia;
    }

    /**
     * Data Coupling
     * Functional Cohesion
     */
    public void emptyCart() {
        lstCartMedia.clear();
    }


    /**
     * Data Coupling
     * Functional Cohesion
     */
    public int getTotalMedia() {
        int total = 0;
        for (CartMedia obj : lstCartMedia) {
            total += obj.getQuantity();
        }
        return total;
    }


    /**
     * Data Coupling
     * Functional Cohesion
     */
    public int calSubtotal() {
        int total = 0;
        for (CartMedia obj : lstCartMedia) {
            total += obj.getPrice() * obj.getQuantity();
        }
        return total;
    }


    /**
     * Data Coupling
     * Procedural Cohesion
     */
    public void checkAvailabilityOfProduct() throws SQLException {
        boolean allAvai = true;
        for (CartMedia object : lstCartMedia) {
            int requiredQuantity = object.getQuantity();
            int availQuantity = object.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvai = false;
        }
        if (!allAvai) throw new MediaNotAvailableException("Some media not available");
    }


    /**
     * Data Coupling
     * Functional Cohesion
     */
    public CartMedia checkMediaInCart(Media media) {
        for (CartMedia cartMedia : lstCartMedia) {
            if (cartMedia.getMedia().getId() == media.getId()) return cartMedia;
        }
        return null;
    }

}
