package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DVD extends Media {

    String discType;
    String director;
    int runtime;
    String studio;
    String subtitles;
    Date releasedDate;
    String filmType;

    public DVD() throws SQLException {

    }

    public DVD(int id, String title, String category, int price, int quantity, String type, String discType,
               String director, int runtime, String studio, String subtitles, Date releasedDate, String filmType) throws SQLException {
        super(id, title, category, price, quantity, type);
        this.discType = discType;
        this.director = director;
        this.runtime = runtime;
        this.studio = studio;
        this.subtitles = subtitles;
        this.releasedDate = releasedDate;
        this.filmType = filmType;
    }


    /**
     * Data coupling
     */
    public String getDiscType() {
        return this.discType;
    }


    /**
     * Data Coupling
     */
    public DVD setDiscType(String discType) {
        this.discType = discType;
        return this;
    }


    /**
     * Data coupling
     */
    public String getDirector() {
        return this.director;
    }


    /**
     * Data coupling
     */
    public DVD setDirector(String director) {
        this.director = director;
        return this;
    }


    /**
     * Data coupling
     */
    public int getRuntime() {
        return this.runtime;
    }


    /**
     * Data coupling
     */
    public DVD setRuntime(int runtime) {
        this.runtime = runtime;
        return this;
    }


    /**
     * Data coupling
     */
    public String getStudio() {
        return this.studio;
    }


    /**
     * Data coupling
     */
    public DVD setStudio(String studio) {
        this.studio = studio;
        return this;
    }


    /**
     *  Data coupling
     */
    public String getSubtitles() {
        return this.subtitles;
    }


    /**
     * Data coupling
     */
    public DVD setSubtitles(String subtitles) {
        this.subtitles = subtitles;
        return this;
    }


    /**
     * Data coupling
     */
    public Date getReleasedDate() {
        return this.releasedDate;
    }


    /**
     * Data coupling
     */
    public DVD setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }


    /**
     * Data Coupling
     */
    public String getFilmType() {
        return this.filmType;
    }


    /**
     * Data coupling
     */
    public DVD setFilmType(String filmType) {
        this.filmType = filmType;
        return this;
    }


    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" + super.toString() + " discType='" + discType + "'" + ", director='" + director + "'" + ", runtime='"
                + runtime + "'" + ", studio='" + studio + "'" + ", subtitles='" + subtitles + "'" + ", releasedDate='"
                + releasedDate + "'" + ", filmType='" + filmType + "'" + "}";
    }


    /**
     * Content Coupling
     */
    @Override
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM " +
                "aims.DVD " +
                "INNER JOIN aims.Media " +
                "ON Media.id = DVD.id " +
                "where Media.id = " + id + ";";
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {

            // from media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from DVD table
            String discType = res.getString("discType");
            String director = res.getString("director");
            int runtime = res.getInt("runtime");
            String studio = res.getString("studio");
            String subtitles = res.getString("subtitle");
            Date releasedDate = res.getDate("releasedDate");
            String filmType = res.getString("filmType");

            return new DVD(id, title, category, price, quantity, type, discType, director, runtime, studio, subtitles, releasedDate, filmType);

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
}
