package dto;

public class OrderDto {

    private int id;
    private String address;
    private String phone;
    private int userID;
    private int shippingFee;
    private String status;
    private String province;
    private String name;


    // Constructors, getters, and setters

    public OrderDto(int id, String address, String phone, int shippingFee,
                    String status, String province, String name) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.shippingFee = shippingFee;
        this.status = status;
        this.province = province;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
