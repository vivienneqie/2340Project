package sample;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;

import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jdk.nashorn.api.scripting.JSObject;

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
//        addFileOptions(file);
        mb.getMenus().addAll(file, edit, view);
        bp.setTop(mb);
        bp.setCenter(mapView);
        bp.setBottom(goHome);

        Scene scene = new Scene(bp);
        stage.setScene(scene);
    }

//    private void addFileOptions(Menu file) {
//        MenuItem close = new MenuItem("Close");
//        close.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                stage.close();
//                app.goToHome();
//            }
//        });
//    }

    /**
     * Add marker to map
     *
     * @param location location of marker
     */
    private void addMarkerToMap(GoogleMap map, Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        LatLong position = new LatLong(longitude, latitude);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(position);
        Marker marker = new Marker(markerOptions);
        marker.setVisible(true);
        marker.setTitle(location.getName());

        map.addUIEventHandler(marker,
                UIEventType.click,
                obj -> {
                    InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
                    InfoWindow window = new InfoWindow(infoWindowOptions);
                    window.open(map, marker);
                });

        map.addMarker(marker);
    }

    @Override
    public void mapInitialized() {
        mapView.addMapInializedListener(this);
        MapOptions options = new MapOptions();
        LatLong center = new LatLong(33.7, -84.4);

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

        Location l = new Location("gatech", 33.46, 84.24);
        addMarkerToMap(map, l);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    /**
     * A getter method for bp bc i'm dum
     * @return bp
     */
    public BorderPane getBp() {
        setUpMapView(stage);
        return bp;
    }
}
