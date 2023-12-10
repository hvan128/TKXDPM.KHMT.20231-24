package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CD extends Media {

    String artist;
    String recordLabel;
    String musicType;
    Date releasedDate;

    public CD() throws SQLException {

    }

    public CD(int id, String title, String category, int price, int quantity, String type, String artist,
              String recordLabel, String musicType, Date releasedDate) throws SQLException {
        super(id, title, category, price, quantity, type);
        this.artist = artist;
        this.recordLabel = recordLabel;
        this.musicType = musicType;
        this.releasedDate = releasedDate;
    }


    /**
     * Data coupling
     */
    public String getArtist() {
        return this.artist;
    }


    /**
     * Data coupling
     */
    public CD setArtist(String artist) {
        this.artist = artist;
        return this;
    }


    /**
     * Data Coupling
     */
    public String getRecordLabel() {
        return this.recordLabel;
    }


    /**
     * Data coupling
     */
    public CD setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
        return this;
    }


    /**
     * Data Coupling
     */
    public String getMusicType() {
        return this.musicType;
    }


    /**
     * Data Coupling
     */
    public CD setMusicType(String musicType) {
        this.musicType = musicType;
        return this;
    }


    /**
     * Data Coupling
     */
    public Date getReleasedDate() {
        return this.releasedDate;
    }


    /**
     * Data coupling
     */
    public CD setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }


    /**
     * Data Coupling
     */
    @Override
    public String toString() {
        return "{" + super.toString() + " artist='" + artist + "'" + ", recordLabel='" + recordLabel + "'"
                + "'" + ", musicType='" + musicType + "'" + ", releasedDate='"
                + releasedDate + "'" + "}";
    }


    /**
     * Functional Cohesion
     */
    @Override
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM " +
                "aims.CD " +
                "INNER JOIN aims.Media " +
                "ON Media.id = CD.id " +
                "where Media.id = " + id + ";";
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {

            // from media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from CD table
            String artist = res.getString("artist");
            String recordLabel = res.getString("recordLabel");
            String musicType = res.getString("musicType");
            Date releasedDate = res.getDate("releasedDate");

            return new CD(id, title, category, price, quantity, type,
                    artist, recordLabel, musicType, releasedDate);

        } else {
            throw new SQLException();
        }
    }


    /**
     * Content Coupling
     * Coincidental Cohesion
     */
    @Override
    public List getAllMedia() {
        return null;
    }

}
