package subsystem;

//import entity.payment.CreditCard;

import entity.payment.PaymentTransaction;
import subsystem.vnPay.VnPaySubsystemController;

import java.io.IOException;
import java.util.Map;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 *
 * @author hieud
 *
 */
/**
 * SOLID: Đảm bảo SOLID
 */
public class VnPaySubsystem implements VnPayInterface {

    /**
     * Represent the controller of the subsystem.
     */
    private VnPaySubsystemController ctrl;

    /**
     * Initializes a newly created {@code InterbankSubsystem} object so that it
     * represents an Interbank subsystem.
     */
    public VnPaySubsystem() {
        String str = new String();
        this.ctrl = new VnPaySubsystemController();
    }

    /**
     * @see VnPayInterface#payOrder(entity.payment.CreditCard, int,
     * java.lang.String)
     */
    //Functional cohesion
    public String generatePayUrl(int amount, String contents) {

        try {
            return ctrl.generatePayOrderUrl(amount, contents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @see VnPayInterface#refund(entity.payment.CreditCard, int,
     * java.lang.String)
     */
    //Functional cohesion
    public PaymentTransaction refund(int amount, String contents) {
        PaymentTransaction transaction = ctrl.refund(amount, contents);
        return transaction;
    }
    //Functional cohesion
    public PaymentTransaction makePaymentTransaction(Map<String, String> response) {
        return ctrl.makePaymentTransaction(response);
    }
}
