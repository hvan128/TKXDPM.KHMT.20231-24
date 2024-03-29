package views.screen;

import java.io.IOException;
import java.util.Hashtable;
import controller.BaseController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.screen.home.HomeScreenHandler;
import views.screen.management.ManagementScreenHandler;

public class BaseScreenHandler extends FXMLScreenHandler {
	private Scene scene;
	private BaseScreenHandler prev;
	protected final Stage stage;
	protected HomeScreenHandler homeScreenHandler;
	protected ManagementScreenHandler managementScreenHandler;
	protected Hashtable<String, String> messages;
	private BaseController bController;
	private String previousScreenTitle;

	private BaseScreenHandler(String screenPath) throws IOException {
		super(screenPath);
		this.stage = new Stage();
	}

	public void setPreviousScreen(BaseScreenHandler prev) {
		this.prev = prev;
	}

	public String getScreenTitle() {
	    return this.stage.getTitle();
	}
	
	public BaseScreenHandler getPreviousScreen() {
		return this.prev;
	}
	
	public BaseScreenHandler(Stage stage, String screenPath) throws IOException {
		super(screenPath);
		this.stage = stage;
	}

	public void show() {
		if (this.scene == null) {
			this.scene = new Scene(this.content);
		}
	    
		this.stage.setScene(this.scene);
		this.stage.show();
	}
	
	public void setScreenTitle(String string) {
		this.stage.setTitle(string);
		this.previousScreenTitle = string;
	}

	public void setBController(BaseController bController){
		this.bController = bController;
	}

	public BaseController getBController(){
		return this.bController;
	}

	public void forward(Hashtable messages) {
		this.messages = messages;
	}

	public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
		this.homeScreenHandler = HomeScreenHandler;
	}
	public void setManagementScreenHandler(ManagementScreenHandler ManagementScreenHandler) {
		this.managementScreenHandler = ManagementScreenHandler;
	}
	
	public String getPreviousScreenTitle() {
	    return this.previousScreenTitle;
	}

}
