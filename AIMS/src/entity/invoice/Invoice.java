package entity.invoice;

import entity.order.Order;

/**
 * Update Coupling - Cohesion:
 * Coupling - Cohesion thấp do sử dụng getter/setter cho từng thuộc tính
 */

public class Invoice {

    private Order order;
    private int amount;

    public Invoice() {

    }

    public Invoice(Order order) {
        this.order = order;
    }


    /**
     * Data Coupling
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Data Coupling
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Data Coupling
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void saveInvoice() {

    }
}
