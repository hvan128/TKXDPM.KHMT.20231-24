package entity.shipping;

import jdk.jshell.spi.ExecutionControl;

public class Shipment {

    private int shipType;

    private String deliveryInstruction;

    private String shipmentDetail;

    private String deliveryTime;

    //constructor operation

    /**
     * Control Coupling
     */
    public Shipment(int shipType, String deliveryInstruction, String shipmentDetail, String deliveryTime) {
        super();
        if (shipType == utils.Configs.PLACE_RUSH_ORDER) {
            this.deliveryInstruction = deliveryInstruction;
            this.shipmentDetail = shipmentDetail;
            this.deliveryTime = deliveryTime;
        }
    }

    public Shipment(int shipType) {
        super();
    }


    /**
     * Data Coupling
     */
    //getter setter method
    public String getDeliveryInstruction() {
        return this.deliveryInstruction;
    }

    public void validateDeliveryInfo() {
        // TODO: implement later on
    }


    /**
     *
     */
    public Shipment createNewShipment() throws ExecutionControl.NotImplementedException {
        // TODO: implement later on
        throw new ExecutionControl.NotImplementedException("abc");
    }
}