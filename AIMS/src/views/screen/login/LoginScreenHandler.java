package views.screen.login;

import common.exception.MediaNotAvailableException;
import entity.order.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

public class LoginScreenHandler extends BaseScreenHandler {

    private static Logger LOGGER = Utils.getLogger(LoginScreenHandler.class.getName());


    public LoginScreenHandler(Stage stage, String screenPath) throws IOException {

        super(stage, screenPath);
        show();

    }

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void loginAction() {
    	String username = usernameField.getText();
        String password = passwordField.getText();

        // Perform login validation here
        if (username.equals("tuan") && password.equals("1234")) {
            // Correct login, navigate to home page
        	homeScreenHandler.show();
        }  
        else {
            // Incorrect login, show alert
        	showAlert("Notification", "Login Failed", "Please check your username and password.");
        }
    }
    private void showAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}

