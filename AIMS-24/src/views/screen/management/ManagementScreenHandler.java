package views.screen.management;

import controller.ManagementController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.admin.AdminConfirmOrderScreenHandler;
import views.screen.admin.AdminScreenHandler;
import views.screen.home.HomeScreenHandler;
import views.screen.management.media.MediaManagementScreenHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManagementScreenHandler extends BaseScreenHandler implements Initializable {
//    @FXML
//    protected Button mediaManage;
    @FXML
    private Button confirmOrderBtn;
    @FXML
    protected Button orderManage;
    @FXML
    protected Button manageMedia;
    @FXML
    private ImageView aimsImage;

    @FXML private AnchorPane contentAdminAnchorPane;
    protected HomeScreenHandler home;


    public ManagementScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImage();
        manageMedia.setOnMouseClicked(e -> {
            openMediaManage();
        });
        confirmOrderBtn.setOnMouseClicked(e -> {
            //TODO
        	AdminScreenHandler adminScreen;
        	try {
        		adminScreen = new AdminScreenHandler(this.stage, Configs.ADMIN_SCREEN_PATH);
        		adminScreen.setHomeScreenHandler(this.home);
        		adminScreen.setScreenTitle("Admin Screen");
        		adminScreen.requestToViewAdminScreen(this);
        	
        	} catch (IOException e1) {
        		e1.printStackTrace();
        	}
        });
        aimsImage.setOnMouseClicked(e -> {
            System.out.println("back home");
            backToHome();
        });
    }

    public void openMediaManage() {
        try {
            MediaManagementScreenHandler mediaManageScreen = new MediaManagementScreenHandler(this.stage, Configs.MANAGEMENT_PATH);
            mediaManageScreen.setHomeScreenHandler(this.home);
            mediaManageScreen.setBController(new ManagementController());
            mediaManageScreen.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void backToHome() {
        try {
            HomeScreenHandler homeHandler = new HomeScreenHandler(stage, Configs.HOME_PATH);
            homeHandler.setScreenTitle("Home Screen");
            homeHandler.setImage();
            homeHandler.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void setImage(){
        File logoFile = new File(Configs.IMAGE_PATH + "/logo.png");
        Image img = new Image(logoFile.toURI().toString());
        aimsImage.setImage(img);
    }
}
