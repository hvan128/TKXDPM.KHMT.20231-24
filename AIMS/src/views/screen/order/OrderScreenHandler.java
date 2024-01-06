//package views.screen.order;
//
//import controller.CancelOrderController;
//import entity.order.Order;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//import views.screen.BaseScreenHandler;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import java.util.List;
//
//public class OrderScreenHandler extends BaseScreenHandler {
//
//    @FXML
//    private ImageView orderImage;
//    @FXML
//    private Label numMediaInOrder;
//    @FXML
//    private ListView<Order> orderListView; // Giả định Order là lớp mô hình cho đơn hàng
//    @FXML
//    private Button btnCancelOrder;
//
//    private CancelOrderController orderController;
//
//    public OrderScreenHandler(Stage stage, String screenPath) throws IOException {
//        super(stage, screenPath);
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        this.orderController = new CancelOrderController();
//
//        // Khởi tạo danh sách đơn hàng
//        initializeOrderListView();
//
//        orderImage.setOnMouseClicked(e -> handleViewOrder());
//        btnCancelOrder.setOnAction(e -> handleCancelOrder());
//    }
//
//    private void initializeOrderListView() {
//        // Lấy danh sách đơn hàng và hiển thị
//        List<Order> orders = orderController.getOrders();
//        orderListView.getItems().setAll(orders);
//        // Cài đặt các thuộc tính cho các cột nếu cần
//    }
//
//    private void handleViewOrder() {
//    }
//
//    private void handleCancelOrder() {
//        // Xử lý hủy đơn hàng
//        Order selectedOrder = orderListView.getSelectionModel().getSelectedItem();
//        if (selectedOrder != null) {
//            orderController.cancelOrder(selectedOrder);
//            initializeOrderListView();
//        }
//    }
//
//    public void updateNumMediaInOrder(int num) {
//        numMediaInOrder.setText(num + " media");
//    }
//
//}
package views.screen.order;

import common.exception.MediaNotAvailableException;
import common.exception.PlaceOrderException;
import controller.PlaceOrderController;
import controller.ViewCartController;
import entity.cart.CartMedia;
import entity.order.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.popup.PopupScreen;
import views.screen.shipping.ShippingScreenHandler;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class OrderScreenHandler extends BaseScreenHandler {

    private static Logger LOGGER = Utils.getLogger(OrderScreenHandler.class.getName());
    @FXML
    VBox vboxOrder;
    @FXML
    private ImageView aimsImage;
    @FXML
    private Label pageTitle;
    @FXML
    private Label shippingFees;

    @FXML
    private Label labelAmount;

    @FXML
    private Label labelSubtotal;

    @FXML
    private Label labelVAT;

    @FXML
    private Button btnPlaceOrder;

    public OrderScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);

        // fix relative image path caused by fxml
        File file = new File("assets/images/Logo.png");
        Image im = new Image(file.toURI().toString());
        aimsImage.setImage(im);

        // on mouse clicked, we back to home
        aimsImage.setOnMouseClicked(e -> {
            homeScreenHandler.show();
        });

        // on mouse clicked, we start processing place order usecase
        btnPlaceOrder.setOnMouseClicked(e -> {

            try {
                requestOrder();
            } catch (SQLException | IOException exp) {

                exp.printStackTrace();
                throw new PlaceOrderException(Arrays.toString(exp.getStackTrace()).replaceAll(", ", "\n"));
            }

        });
    }


    /**
     * @return Label
     */
    public Label getLabelAmount() {
        return labelAmount;
    }


    /**
     * @return Label
     */
    public Label getLabelSubtotal() {
        return labelSubtotal;
    }


    /**
     * @return ViewCartController
     */
    public ViewCartController getBController() {
        return (ViewCartController) super.getBController();
    }


    /**
     * @param prevScreen
     * @throws SQLException
     */
    public void requestToViewCart(BaseScreenHandler prevScreen) throws SQLException {
        setPreviousScreen(prevScreen);
        setScreenTitle("Cart Screen");
        getBController().checkAvailabilityOfProduct();
        displayCartWithMediaAvailability();
        show();
    }


    /**
     * @throws SQLException
     * @throws IOException
     */
    public void requestOrder() throws SQLException, IOException {
        try {
            // create placeOrderController and process the order
            var placeOrderController = new PlaceOrderController();
            if (placeOrderController.getListCartMedia().size() == 0) {
                PopupScreen.error("You don't have anything to place");
                return;
            }

            placeOrderController.placeOrder();

            // display available media
//            displayCartWithMediaAvailability();

            // create order
            Order order = placeOrderController.createOrder();

            // display shipping form
            ShippingScreenHandler ShippingScreenHandler = new ShippingScreenHandler(this.stage, Configs.SHIPPING_SCREEN_PATH, order);
            ShippingScreenHandler.setPreviousScreen(this);
            ShippingScreenHandler.setHomeScreenHandler(homeScreenHandler);
            ShippingScreenHandler.setScreenTitle("Shipping Screen");
            ShippingScreenHandler.setBController(placeOrderController);
            ShippingScreenHandler.show();

        } catch (MediaNotAvailableException e) {
            // if some media are not available then display cart and break usecase Place Order
            displayCartWithMediaAvailability();
        }
    }


    /**
     * @throws SQLException
     */
    public void updateCart() throws SQLException {
        getBController().checkAvailabilityOfProduct();
        displayCartWithMediaAvailability();
    }

    void updateCartAmount() {
        // calculate subtotal and amount
        int subtotal = getBController().getCartSubtotal();
        int vat = (int) ((Configs.PERCENT_VAT / 100) * subtotal);
        int amount = subtotal + vat;


        // update subtotal and amount of Cart
        labelSubtotal.setText(Utils.getCurrencyFormat(subtotal));
        labelVAT.setText(Utils.getCurrencyFormat(vat));
        labelAmount.setText(Utils.getCurrencyFormat(amount));
    }

    private void displayCartWithMediaAvailability() {
        // clear all old cartMedia
        vboxOrder.getChildren().clear();

        // get list media of cart after check availability
        List lstMedia = getBController().getListCartMedia();

        try {
            for (Object cm : lstMedia) {

                // display the attribute of vboxOrder media
                CartMedia cartMedia = (CartMedia) cm;
                MediaHandler mediaCartScreen = new MediaHandler(Configs.CART_MEDIA_PATH, this);
                mediaCartScreen.setCartMedia(cartMedia);

                // add spinner
                vboxOrder.getChildren().add(mediaCartScreen.getContent());
            }
            // calculate subtotal and amount
            updateCartAmount();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
