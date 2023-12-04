package entity.user;

public class User {

    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;

    public User(int id, String name, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }


    /**
     * Data Coupling
     */
    // override toString method
    @Override
    public String toString() {
        return "{" +
                "  username='" + name + "'" +
                ", email='" + email + "'" +
                ", address='" + address + "'" +
                ", phone='" + phone + "'" +
                "}";
    }


    /**
     * Data Coupling
     */
    // getter and setter
    public String getName() {
        return this.name;
    }


    /**
     * Data Coupling
     */
    public void setusername(String name) {
        this.name = name;
    }


    /**
     * Data Coupling
     */
    public String getEmail() {
        return this.email;
    }


    /**
     * Sata Coupling
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Data Coupling
     */
    public String getAddress() {
        return this.address;
    }


    /**
     * Data Coupling
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * Data Coupling
     */
    public String getPhone() {
        return this.phone;
    }


    /**
     * Data Coupling
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
