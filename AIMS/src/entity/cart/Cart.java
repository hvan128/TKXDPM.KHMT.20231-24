package entity.cart;

import common.exception.MediaNotAvailableException;
import entity.media.Media;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private static Cart cartInstance;
    private List<CartMedia> lstCartMedia;


    private Cart() {
        lstCartMedia = new ArrayList<>();
    }

    /**
     * Data Coupling
     */
    public static Cart getCart() {
        if (cartInstance == null) cartInstance = new Cart();
        return cartInstance;
    }

    /**
     *  Data Coupling
     */
    public void addCartMedia(CartMedia cm) {
        lstCartMedia.add(cm);
    }


    /**
     * Stamp Coupling
     */
    public void removeCartMedia(CartMedia cm) {
        lstCartMedia.remove(cm);
    }


    /**
     * Data Coupling
     */
    public List getListMedia() {
        return lstCartMedia;
    }

    /**
     * Data Coupling
     */
    public void emptyCart() {
        lstCartMedia.clear();
    }


    /**
     * Data Coupling
     */
    public int getTotalMedia() {
        int total = 0;
        for (Object obj : lstCartMedia) {
            CartMedia cm = (CartMedia) obj;
            total += cm.getQuantity();
        }
        return total;
    }


    /**
     * Data Coupling
     */
    public int calSubtotal() {
        int total = 0;
        for (Object obj : lstCartMedia) {
            CartMedia cm = (CartMedia) obj;
            total += cm.getPrice() * cm.getQuantity();
        }
        return total;
    }


    /**
     * Data Coupling
     */
    public void checkAvailabilityOfProduct() throws SQLException {
        boolean allAvai = true;
        for (Object object : lstCartMedia) {
            CartMedia cartMedia = (CartMedia) object;
            int requiredQuantity = cartMedia.getQuantity();
            int availQuantity = cartMedia.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvai = false;
        }
        if (!allAvai) throw new MediaNotAvailableException("Some media not available");
    }


    /**
     * Data Coupling
     */
    public CartMedia checkMediaInCart(Media media) {
        for (CartMedia cartMedia : lstCartMedia) {
            if (cartMedia.getMedia().getId() == media.getId()) return cartMedia;
        }
        return null;
    }

}
