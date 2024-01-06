package controller;

import entity.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ManagementController extends BaseController {
    Media media;

    public ManagementController() {
        media = new Media();
    }

    public ManagementController(Media media) {
        this.media = media;
    }

    public ObservableList<Media> getAllMedia() throws SQLException {
        return FXCollections.observableArrayList(media.getAllMedia());
    }

    public Media getMediaById(int id) throws SQLException {
        return media.getMediaById(id);
    }

    public void saveMedia(Media media) throws SQLException {
        media.save();
    }

    public void deleteMediaById(int id) throws SQLException {
        media.delete(id);
    }
}
