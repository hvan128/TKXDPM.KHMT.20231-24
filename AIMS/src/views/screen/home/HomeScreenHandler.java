package views.screen.home;

import common.exception.ViewCartException;
import controller.HomeController;
import controller.ViewCartController;
import entity.cart.Cart;
import entity.media.Media;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.cart.CartScreenHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * SOLID: Đảm bảo SOLID
 * quản lý màn hình chính của ứng dụng, lớp có các phần phụ thuộc vào HomeController, ViewCartController
 */


public class HomeScreenHandler extends BaseScreenHandler implements Initializable {
    /*
     * Functional cohesion
     */
    public static Logger LOGGER = Utils.getLogger(HomeScreenHandler.class.getName());

    @FXML
    private Label numMediaInCart;

    @FXML
    private ImageView aimsImage;

    @FXML
    private ImageView cartImage;

    @FXML
    private VBox vboxMedia1;

    @FXML
    private VBox vboxMedia2;

    @FXML
    private VBox vboxMedia3;

    @FXML
    private HBox hboxMedia;

    @FXML
    private SplitMenuButton splitMenuBtnSearch;

    @FXML 
    private TextField inputMenuSearch;

    @FXML
    private SplitMenuButton splitMenuBtnSortPrice;

    private List homeItems;

    /**
     * SOLID: Đảm bảo SOLID
     * Có thể xem xét numMediaCartLabel trong HomeScreenHandler sang Cart
     */

    public HomeScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    /**
     * @return Label
     */
    public Label getNumMediaCartLabel() {
        return this.numMediaInCart;
    }

    /**
     * @return HomeController
     */
    public HomeController getBController() {
        return (HomeController) super.getBController();
    }

    @Override
    public void show() {
        numMediaInCart.setText(String.valueOf(Cart.getCart().getListMedia().size()) + " media");
        super.show();
    }

    private String currentSearchKeyword = "";
    private String currentSearchType = "";

    /**
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        setBController(new HomeController());
        try {
            List medium = getBController().getAllMedia();
            this.homeItems = new ArrayList<>();
            for (Object object : medium) {
                Media media = (Media) object;
                MediaHandler m1 = new MediaHandler(Configs.HOME_MEDIA_PATH, media, this);
                this.homeItems.add(m1);
            }
        } catch (SQLException | IOException e) {
            LOGGER.info("Errors occured: " + e.getMessage());
            e.printStackTrace();
        }

        aimsImage.setOnMouseClicked(e -> {
            addMediaHome(this.homeItems);
        });

        cartImage.setOnMouseClicked(e -> {
            CartScreenHandler cartScreen;
            try {
                LOGGER.info("User clicked to view cart");
                cartScreen = new CartScreenHandler(this.stage, Configs.CART_SCREEN_PATH);
                cartScreen.setHomeScreenHandler(this);
                cartScreen.setBController(new ViewCartController());
                cartScreen.requestToViewCart(this);
            } catch (IOException | SQLException e1) {
                throw new ViewCartException(Arrays.toString(e1.getStackTrace()).replaceAll(", ", "\n"));
            }
        });

        inputMenuSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filterMedia(newValue, currentSearchType, false, "id");
        });
        
        splitMenuBtnSortPrice.getItems().get(0).setOnAction(e -> filterMedia(currentSearchKeyword, currentSearchType, true, "price"));
        splitMenuBtnSortPrice.getItems().get(1).setOnAction(e -> filterMedia(currentSearchKeyword, currentSearchType, false, "price"));
        splitMenuBtnSortPrice.getItems().get(2).setOnAction(e -> filterMedia(currentSearchKeyword, currentSearchType, false, "id"));

        addMediaHome(this.homeItems);
        addMenuItem(0, "Book", splitMenuBtnSearch);
        addMenuItem(1, "DVD", splitMenuBtnSearch);
        addMenuItem(2, "CD", splitMenuBtnSearch);
    }

    public void setImage() {
        // fix image path caused by fxml
        File file1 = new File(Configs.IMAGE_PATH + "/" + "Logo.png");
        Image img1 = new Image(file1.toURI().toString());
        aimsImage.setImage(img1);

        File file2 = new File(Configs.IMAGE_PATH + "/" + "cart.png");
        Image img2 = new Image(file2.toURI().toString());
        cartImage.setImage(img2);
    }

    /**
     * @param items
     */
    public void addMediaHome(List items) {
        ArrayList mediaItems = (ArrayList) ((ArrayList) items).clone();
        hboxMedia.getChildren().forEach(node -> {
            VBox vBox = (VBox) node;
            vBox.getChildren().clear();
        });
        while (!mediaItems.isEmpty()) {
            hboxMedia.getChildren().forEach(node -> {
                int vid = hboxMedia.getChildren().indexOf(node);
                VBox vBox = (VBox) node;
                while (vBox.getChildren().size() < 3 && !mediaItems.isEmpty()) {
                    MediaHandler media = (MediaHandler) mediaItems.get(0);
                    vBox.getChildren().add(media.getContent());
                    mediaItems.remove(media);
                }
            });
            return;
        }
    }

    /**
     * @param position
     * @param text
     * @param menuButton
     */
    private void addMenuItem(int position, String text, MenuButton menuButton) {
        inputMenuSearch.setText("");
        MenuItem menuItem = new MenuItem();
        Label label = new Label();
        label.prefWidthProperty().bind(menuButton.widthProperty().subtract(31));
        label.setText(text);
        label.setTextAlignment(TextAlignment.RIGHT);
        menuItem.setGraphic(label);
        menuItem.setOnAction(e -> {
            // empty home media
            LOGGER.info("Add menu item: " + text);
            hboxMedia.getChildren().forEach(node -> {
                VBox vBox = (VBox) node;
                vBox.getChildren().clear();
            });

            // filter only media with the choosen category
            List filteredItems = new ArrayList<>();
            homeItems.forEach(me -> {
                MediaHandler media = (MediaHandler) me;
                if (media.getMedia().getTitle().toLowerCase().startsWith(text.toLowerCase())) {
                    filteredItems.add(media);
                }
            });

            // fill out the home with filted media as category
            addMediaHome(filteredItems);
        });
        menuButton.getItems().add(position, menuItem);
    }

    /**
     * @param keyword
     * @param typeSearch
     * @param boolean
     * @param searchBy
     */

    private void filterMedia(String keyword, String typeSearch, boolean desc, String searchBy) {
        currentSearchKeyword = keyword;
        currentSearchType = typeSearch;

        List<MediaHandler> filteredItems = getFilteredMedia(keyword, typeSearch);

        switch (searchBy) {
            case "price":
                filteredItems.sort(Comparator.comparingDouble(mediaHandler -> mediaHandler.getMedia().getPrice()));
                break;
            case "id":
                filteredItems.sort(Comparator.comparingInt(mediaHandler -> mediaHandler.getMedia().getId()));
                break;
        }

        if (desc) {
            Collections.reverse(filteredItems);
        }

        addMediaHome(filteredItems);
    }

    private List<MediaHandler> getFilteredMedia(String keyword, String typeSearch) {
        List<MediaHandler> filteredItems = new ArrayList<>();

        homeItems.forEach(me -> {
            MediaHandler media = (MediaHandler) me;

            boolean matchesKeyword = media.getMedia().getTitle().toLowerCase().contains(keyword.toLowerCase());
            boolean matchesType = typeSearch.isEmpty() || media.getMedia().getType().toLowerCase().equals(typeSearch.toLowerCase());

            if (matchesKeyword && matchesType) {
                filteredItems.add(media);
            }
        });

        return filteredItems;
    }
}
