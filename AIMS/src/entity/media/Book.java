package entity.media;

import entity.db.AIMSDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class Book extends Media {

    String author;
    String coverType;
    String publisher;
    Date publishDate;
    int numOfPages;
    String language;
    String bookCategory;

    public Book() throws SQLException {

    }

    public Book(int id, String title, String category, int price, int quantity, String type, String author,
                String coverType, String publisher, Date publishDate, int numOfPages, String language,
                String bookCategory) throws SQLException {
        super(id, title, category, price, quantity, type);
        this.author = author;
        this.coverType = coverType;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.numOfPages = numOfPages;
        this.language = language;
        this.bookCategory = bookCategory;
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
    public String getAuthor() {
        return this.author;
    }


    /**
     * Data Coupling
     */
    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }


    /**
     * Data Coupling
     */
    public String getCoverType() {
        return this.coverType;
    }


    /**
     * Data Coupling
     */
    public Book setCoverType(String coverType) {
        this.coverType = coverType;
        return this;
    }


    /**
     * Data Coupling
     */
    public String getPublisher() {
        return this.publisher;
    }


    /**
     * Data Coupling
     */
    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }


    /**
     * Data Coupling
     */
    public Date getPublishDate() {
        return this.publishDate;
    }


    /**
     * Data Coupling
     */
    public Book setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
        return this;
    }


    /**
     * Data Coupling
     */
    public int getNumOfPages() {
        return this.numOfPages;
    }


    /**
     * Data Coupling
     */
    public Book setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
        return this;
    }


    /**
     * Data Coupling
     */
    public String getLanguage() {
        return this.language;
    }


    /**
     * Data Coupling
     */
    public Book setLanguage(String language) {
        this.language = language;
        return this;
    }


    /**
     * Data Coupling
     */
    public String getBookCategory() {
        return this.bookCategory;
    }


    /**
     * Data Coupling
     */
    public Book setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
        return this;
    }


    /**
     * Content coupling
     *
     */
    @Override
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM " +
                "aims.Book " +
                "INNER JOIN aims.Media " +
                "ON Media.id = Book.id " +
                "where Media.id = " + id + ";";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {

            // from Media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from Book table
            String author = res.getString("author");
            String coverType = res.getString("coverType");
            String publisher = res.getString("publisher");
            Date publishDate = res.getDate("publishDate");
            int numOfPages = res.getInt("numOfPages");
            String language = res.getString("language");
            String bookCategory = res.getString("bookCategory");

            return new Book(id, title, category, price, quantity, type,
                    author, coverType, publisher, publishDate, numOfPages, language, bookCategory);

        } else {
            throw new SQLException();
        }
    }


    /**
     * Data Coupling
     */
    @Override
    public List getAllMedia() {
        return null;
    }


    /**
     * Data Coupling
     */
    @Override
    public String toString() {
        return "{" +
                super.toString() +
                " author='" + author + "'" +
                ", coverType='" + coverType + "'" +
                ", publisher='" + publisher + "'" +
                ", publishDate='" + publishDate + "'" +
                ", numOfPages='" + numOfPages + "'" +
                ", language='" + language + "'" +
                ", bookCategory='" + bookCategory + "'" +
                "}";
    }
}
