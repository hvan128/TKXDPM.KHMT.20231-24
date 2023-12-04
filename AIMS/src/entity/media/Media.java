package entity.media;

import entity.db.AIMSDB;
import utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * The general media class, for another media it can be done by inheriting this class
 *
 * @author nguyenlm
 */
public class Media {

    protected static boolean isSupportedPlaceRushOrder = new Random().nextBoolean();
    private static Logger LOGGER = Utils.getLogger(Media.class.getName());
    protected Statement stm;
    protected int id;
    protected String title;
    protected String category;
    protected int value; // the real price of product (eg: 450)
    protected int price; // the price which will be displayed on browser (eg: 500)
    protected int quantity;
    protected String type;
    protected String imageURL;

    public Media() throws SQLException {
        stm = AIMSDB.getConnection().createStatement();
    }

    public Media(int id, String title, String category, int price, int quantity, String type) throws SQLException {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.type = type;

        //stm = AIMSDB.getConnection().createStatement();
    }

    /**
     * Data coupling
     */
    public static boolean getIsSupportedPlaceRushOrder() {
        return Media.isSupportedPlaceRushOrder;
    }

    /**
     * Data coupling
     */
    public int getQuantity() throws SQLException {
        int updated_quantity = getMediaById(id).quantity;
        this.quantity = updated_quantity;
        return updated_quantity;
    }

    /**
     * Data coupling
     */
    public Media setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Data coupling
     */
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM Media ;";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {

            return new Media()
                    .setId(res.getInt("id"))
                    .setTitle(res.getString("title"))
                    .setQuantity(res.getInt("quantity"))
                    .setCategory(res.getString("category"))
                    .setMediaURL(res.getString("imageUrl"))
                    .setPrice(res.getInt("price"))
                    .setType(res.getString("type"));
        }
        return null;
    }

    /**
     * Data Coupling
     */
    public List getAllMedia() throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery("select * from Media");
        ArrayList medium = new ArrayList<>();
        while (res.next()) {
            Media media = new Media()
                    .setId(res.getInt("id"))
                    .setTitle(res.getString("title"))
                    .setQuantity(res.getInt("quantity"))
                    .setCategory(res.getString("category"))
                    .setMediaURL(res.getString("imageUrl"))
                    .setPrice(res.getInt("price"))
                    .setType(res.getString("type"));
            medium.add(media);
        }
        return medium;
    }

    /**
     * Data Coupling
     */
    public void updateMediaFieldById(String tbname, int id, String field, Object value) throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        if (value instanceof String) {
            value = "\"" + value + "\"";
        }
        stm.executeUpdate(" update " + tbname + " set" + " "
                + field + "=" + value + " "
                + "where id=" + id + ";");
    }

    /**
     * Data Coupling
     */
    // getter and setter
    public int getId() {
        return this.id;
    }

    /**
     * Data Coupling
     */
    private Media setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Data Coupling
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Data Coupling
     */
    public Media setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Data Coupling
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Data Coupling
     */
    public Media setCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * Data Coupling
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Data coupling
     */
    public Media setPrice(int price) {
        this.price = price;
        return this;
    }

    /**
     * data coupling
     */
    public String getImageURL() {
        return this.imageURL;
    }

    /**
     * Data Coupling
     */
    public Media setMediaURL(String url) {
        this.imageURL = url;
        return this;
    }

    /**
     * Data Coupling
     */
    public String getType() {
        return this.type;
    }

    /**
     * Data Coupling
     */
    public Media setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Data Coupling
     */
    @Override
    public String toString() {
        return "{" +
                " id='" + id + "'" +
                ", title='" + title + "'" +
                ", category='" + category + "'" +
                ", price='" + price + "'" +
                ", quantity='" + quantity + "'" +
                ", type='" + type + "'" +
                ", imageURL='" + imageURL + "'" +
                "}";
    }

}