package views.screen.login;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.login.LoginScreenHandler;
import views.screen.management.ManagementScreenHandler;
import views.screen.home.HomeScreenHandler;

import java.io.IOException;

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
        	   HomeScreenHandler homeScreenHandler;
            try {
              	homeScreenHandler = new HomeScreenHandler(this.stage, Configs.HOME_PATH);
              	homeScreenHandler.setImage();
                homeScreenHandler.show();
                
            } catch (IOException ex) {
              throw new RuntimeException(ex);
            }
        }  
        else if (username.equals("admin") && password.equals("1234")) {
            // Correct login, navigate to admin page
               ManagementScreenHandler managementScreenHandler;
            try {
                LOGGER.info("User clicked to media management");
                managementScreenHandler = new ManagementScreenHandler(this.stage, Configs.MANAGEMENT_PATH);
                managementScreenHandler.openMediaManage();
            } catch (IOException ex) {
              throw new RuntimeException(ex);
            }
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