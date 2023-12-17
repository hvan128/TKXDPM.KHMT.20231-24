package controller;

import entity.media.Media;

import java.sql.SQLException;
import java.util.List;
/**
 * SOLID:
 * Việc chia ra các hàm trong class này đã đúng về nguyên tắc SOLID
 */

/**
 * This class controls the flow of events in homescreen
 *
 * @author nguyenlm
 */
//Coupling
public class HomeController extends BaseController {

    /**
     * this method gets all Media in DB and return back to home to display
     *
     * @return List[Media]
     * @throws SQLException
     */
    //Functional cohesion
    public List getAllMedia() throws SQLException {
        return new Media().getAllMedia();
    }

}
