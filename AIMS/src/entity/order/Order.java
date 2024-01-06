package entity.order;

import dto.OrderDto;
import entity.db.AIMSDB;
import entity.invoice.Invoice;
import entity.shipping.DeliveryInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private DeliveryInfo deliveryInfo;
    private Invoice invoice;
    private String status;

    public Order(OrderDto orderDto) {
        this.id = orderDto.getId();
        this.deliveryInfo = new DeliveryInfo();
        this.deliveryInfo.setShippingAddress(orderDto.getAddress());
        this.deliveryInfo.setPhoneNumber(orderDto.getPhone());
        this.setStatus(orderDto.getStatus());
        this.deliveryInfo.setProvince(orderDto.getProvince());
        this.deliveryInfo.setName("hai van");
    }

    public Order(DeliveryInfo deliveryInfo, Invoice invoice) {
        this.deliveryInfo = deliveryInfo;
        this.invoice = invoice;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int calculateShippingFees() {

        if (getInvoice().getTotalPrice() > 100000) {
            return 0;
        }
        double baseCost = 0;
        double baseWeight = 0;
        double additionalCostPerHalfKg = 0;

        if (getDeliveryInfo().isUrban()) {
            baseCost = 22000;
            baseWeight = 3;
        } else {
            baseCost = 30000;
            baseWeight = 0.5;
        }
        additionalCostPerHalfKg = 2500;

        double rushShippingCost = 0;

        if (getDeliveryInfo().isRushShipping())
            rushShippingCost = 10000 * getInvoice().getNumberOfRushShippingProduct();

        double regularShippingCost = 0;

        if (getInvoice().getMaxWeight() <= baseWeight) {
            regularShippingCost = baseCost;
        } else {
            regularShippingCost = baseCost + Math.ceil((getInvoice().getMaxWeight() - baseWeight) * 2) * additionalCostPerHalfKg;
        }

        return (int) (rushShippingCost + regularShippingCost);
    }

    public static void saveNewOrder(Order order) throws SQLException {
        String sqlStatement = "INSERT INTO `Order` ( address, phone, shipping_fee, status, province, name) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = AIMSDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);

        preparedStatement.setString(2, order.getDeliveryInfo().getShippingAddress());
        preparedStatement.setString(3, order.getDeliveryInfo().getPhoneNumber());
        preparedStatement.setDouble(5, order.calculateShippingFees());
        preparedStatement.setString(6, "CHỜ DUYỆT");
        preparedStatement.setString(7, "hai van");

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Đã thêm thông tin Order vào cơ sở dữ liệu thành công!");
        } else {
            System.out.println("Thêm thông tin Order vào cơ sở dữ liệu không thành công!");
        }
    }

    public static List<Order> getAllOrders() throws SQLException {

        List<Order> orders = new ArrayList<>();

        String sql = "SELECT * FROM `Order`";

        Connection connection = AIMSDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            OrderDto newOrderDto = new OrderDto(
                    resultSet.getInt("id"),
                    resultSet.getString("address"),
                    resultSet.getString("phone"),
                    resultSet.getInt("shipping_fee"),
                    resultSet.getString("status"),
                    resultSet.getString("province"),
                    resultSet.getString("name"),

            Order order = new Order(newOrderDto);
            orders.add(order);
        }

        return orders;
    }

    public static void updateOrderStatus(Integer id, String newState) throws SQLException {
        String sql = "UPDATE `Order` SET status = ? WHERE id = ?";
        Connection connection = AIMSDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, newState);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }
}
