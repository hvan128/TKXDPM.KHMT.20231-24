package entity.payment;

import entity.db.AIMSDB;

import java.sql.*;
import java.util.Date;

public class PaymentTransaction {
    private String errorCode;
    private String transactionId;
    private String transactionContent;
    private int amount;
    private int orderID;
    private Date createdAt;

    public PaymentTransaction(String errorCode, String transactionId, String transactionContent,
                              int amount, Date createdAt) {
        super();
        this.errorCode = errorCode;


        this.transactionId = transactionId;
        this.transactionContent = transactionContent;
        this.amount = amount;
        this.createdAt = createdAt;
    }


    /**
     * @return String
     */
    public String getErrorCode() {
        return this.errorCode;
    }

    public String getTransactionContent() {
        return this.transactionContent;
    }

    public void save(int orderId) throws SQLException {
        this.orderID = orderId;
//        Statement stm = AIMSDB.getConnection().createStatement();
        String query = "INSERT INTO 'Transaction' ( orderID, createAt, content) VALUES ( ?, ?, ?)";
        try (PreparedStatement preparedStatement = AIMSDB.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, this.orderID);
            preparedStatement.setDate(2, new java.sql.Date(this.createdAt.getTime()));
            preparedStatement.setString(3, this.transactionContent);

            preparedStatement.executeUpdate();
        }
    }

}
