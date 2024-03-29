package controller;

import entity.cart.Cart;

import java.sql.SQLException;
/**
 * SOLID:
 * Việc chia ra các hàm trong class này đã đúng về nguyên tắc SOLID
 */

/**
 * This class controls the flow of events when users view the Cart
 *
 * @author nguyenlm
 */
//Coupling

public class ViewCartController extends BaseController {

    /**
     * This method checks the available products in Cart
     *
     * @throws SQLException
     */
    //Functional cohesion
    public void checkAvailabilityOfProduct() throws SQLException {
        Cart.getCart().checkAvailabilityOfProduct();
    }

    /**
     * This method calculates the cart subtotal
     *
     * @return subtotal
     */
    //Functional cohesion
    public int getCartSubtotal() {
        int subtotal = Cart.getCart().calSubtotal();
        return subtotal;
    }

}
