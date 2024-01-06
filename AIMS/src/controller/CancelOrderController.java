package controller;

import entity.cart.Cart;

import java.sql.SQLException;

public class CancelOrderController  extends BaseController{
    public void cancelOrder() throws SQLException {
        Cart.getCart().checkAvailabilityOfProduct();
    }
}
