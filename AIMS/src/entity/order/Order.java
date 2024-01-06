package entity.order;

import utils.Configs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {

    private int shippingFees;
    private List lstOrderMedia;
    private HashMap<String, String> deliveryInfo;

    public Order() {
        this.lstOrderMedia = new ArrayList<>();
    }

    public Order(List lstOrderMedia) {
        this.lstOrderMedia = lstOrderMedia;
    }


    /**
     * Data coupling
     */
    public void addOrderMedia(OrderMedia om) {
        this.lstOrderMedia.add(om);
    }


    /**
     * Stamp coupling
     */
    public void removeOrderMedia(OrderMedia om) {
        this.lstOrderMedia.remove(om);
    }


    /**
     * Data Coupling
     */
    public List getlstOrderMedia() {
        return this.lstOrderMedia;
    }


    /**
     * Data Coupling
     */
    public void setlstOrderMedia(List lstOrderMedia) {
        this.lstOrderMedia = lstOrderMedia;
    }

    /**
     * Data Coupling
     */
    public int getShippingFees() {
        return shippingFees;
    }

    /**
     * Data Coupling
     */
    public void setShippingFees(int shippingFees) {
        this.shippingFees = shippingFees;
    }

    /**
     * Data Coupling
     */
    public HashMap getDeliveryInfo() {
        return deliveryInfo;
    }


    /**
     * Data Coupling
     */
    public void setDeliveryInfo(HashMap deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }


    /**
     * Data Coupling
     */
    public int getAmount() {
        double amount = 0;
        for (Object object : lstOrderMedia) {
            OrderMedia om = (OrderMedia) object;
            amount += om.getPrice();
        }
        return (int) (amount + (Configs.PERCENT_VAT / 100) * amount);
    }

}
