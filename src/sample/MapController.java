package sample;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by b on 10/27/16.
 */
public class MapController implements Initializable, MapComponentInitializedListener {
    private GoogleMapView mapView;
    private GoogleMap map;
    private MainFXApp app;
    private Stage stage;

    //Remove this after scenebuilding
    private BorderPane bp;

    /**
     * Constructor for map controller
     * @param app  reference to the FX application
     * @param stage the stage where the map will be displayed
     */
    public MapController(MainFXApp app, Stage stage) {
        this.app = app;
        this.stage = stage;
        setUpMapView(stage);
    }
    /**
     * Set up the view for the map
     *
     * @param stage the stage on which the map will be put
     */
    private void setUpMapView(Stage stage) {
        mapView = new GoogleMapView();
        mapView.addMapInializedListener(this);
        bp = new BorderPane();
        MenuBar mb = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu view = new Menu("View");
        Button goHome = new Button("Home");
        goHome.setOnAction(event -> {
            stage.close();
            app.goToHome();
        });
        //TODO: add menu options
        mb.getMenus().addAll(file, edit, view);
        bp.setTop(mb);
        bp.setCenter(mapView);
        bp.setBottom(goHome);

        Scene scene = new Scene(bp);
        stage.setScene(scene);
    }

    @Override
    public void mapInitialized() {
        mapView.addMapInializedListener(this);
        MapOptions options = new MapOptions();
        LatLong center = new LatLong(34, -88);

        options.center(center)
                .zoom(9)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);

        map = mapView.createMap(options);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    /**
     * A getter method for bp bc i'm dum
     * @return bp
     */
    public BorderPane getBp() {
        return bp;
    }
}
