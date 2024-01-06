package controller;

import common.exception.PaymentException;
import common.exception.TransactionNotDoneException;
import common.exception.UnrecognizedException;
import entity.cart.Cart;
import subsystem.VnPayInterface;
import subsystem.VnPaySubsystem;

import java.util.Hashtable;
import java.util.Map;
/**
 * SOLID:
 * Việc chia ra các hàm trong class này đã đúng về nguyên tắc SOLID
 */

/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 *
 * @author hieud
 */
//Coupling
public class PaymentController extends BaseController {


    // Function Coupling
    private VnPayInterface vnPayService;
    //Functional cohesion
    public Map<String, String> makePayment(Map<String, String> res) {
        Map<String, String> result = new Hashtable<String, String>();

        try {


            this.vnPayService = new VnPaySubsystem();
            var trans = vnPayService.makePaymentTransaction(res);

            result.put("RESULT", "PAYMENT SUCCESSFUL!");
            result.put("MESSAGE", "You have succesffully paid the order!");
        } catch (PaymentException | UnrecognizedException ex) {
            result.put("MESSAGE", ex.getMessage());
            result.put("RESULT", "PAYMENT FAILED!");

        }
        return result;
    }
    //Functional cohesion
    public void emptyCart() {
        Cart.getCart().emptyCart();
    }
}
