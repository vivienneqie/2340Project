package sample;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;

import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 * Created by b on 10/27/16.
 */
public class MapController implements Initializable, MapComponentInitializedListener {
    private GoogleMapView mapView;
    private MainFXApp app;
    private Stage stage;

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
        BorderPane bp = new BorderPane();
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
        //
        generateReports();
    }

    private void addFileOptions(Menu file) {
        MenuItem close = new MenuItem("Close");
        close.setOnAction(event ->  {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Close");
                stage.close();
                app.goToHome();
        });
    }

    /**
     * Add marker to map
     *
     * @param report corresponding report
     */
    private void addMarkerToMap(GoogleMap map, Report report) {
        Location location = report.getLocation();
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        LatLong position = new LatLong(latitude, longitude);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(position);
        markerOptions.visible(Boolean.TRUE);
        Marker marker = new Marker(markerOptions);
        marker.setVisible(true);
        marker.setTitle(location.getName());

        map.addUIEventHandler(marker,
                UIEventType.click,
                obj -> {
                    InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
                    infoWindowOptions.content("<h2>" + location.getName() + "</h2>"
                            + "Type: " + report.getType() + "<br>"
                            + "Condition: " + report.getCondition() + "<br>");
                    InfoWindow infoWindow = new InfoWindow(infoWindowOptions);
                    infoWindow.open(map, marker);
                });


        map.addMarker(marker);
    }

    @Override
    public void mapInitialized() {
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

        GoogleMap map = mapView.createMap(options);

        ArrayList<Report> reports = generateReports();
        for (Report r : reports != null ? reports : null) {
            addMarkerToMap(map, r);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
    }

    /**
     * A getter method for the stage with the border pane
     * @return stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * retrieves all data from the db and creates all reports
     * @return arrayList of reports
     */
    public static ArrayList<Report> generateReports() {
        ReportDatabase rb = new ReportDatabase();
        ArrayList list = new ArrayList<>();
        ArrayList<Report> ret = new ArrayList<>();
        try {
            Statement stmt = rb.conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT ID FROM AVAILABLE;" );
            while (rs.next()) {
                list.add(rs.getObject("ID"));
            }
            for (Object i : list) {
                String sql = "SELECT * FROM AVAILABLE WHERE ID = ?";
                PreparedStatement stmt2 = rb.conn.prepareStatement(sql);
                stmt2.setInt(1, (Integer) i);
                ResultSet rs2 = stmt2.executeQuery();
                String loc = (String) rs2.getObject("LOCATION");
                String type = (String) rs2.getObject("TYPE");
                String condition = (String) rs2.getObject("CONDITION");
                double lat = (double) rs2.getObject("LATITUDE");
                double longi = (double) rs2.getObject("LONGITUDE");
                Location theLoc = new Location(loc, longi, lat);
                ret.add(new Report(theLoc, type, condition, (Integer) i));
            }
            return ret;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
}
