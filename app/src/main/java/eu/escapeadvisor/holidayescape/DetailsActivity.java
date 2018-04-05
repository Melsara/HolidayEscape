package eu.escapeadvisor.holidayescape;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.URL;

import static eu.escapeadvisor.holidayescape.GlobalConstants.ADDRESS_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.DESC_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.EMAIL_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.IMAGE_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.LAT_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.LNG_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.NAME_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.TEL_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.URL_KEY;

public class DetailsActivity extends FragmentActivity implements OnMapReadyCallback {

    private String url;
    private String name;
    private String email;
    private String tel;
    private double lat;
    private double lng;
    private int image;
    private String description;
    private String address;
    LatLng position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

        Intent openDetailsActivity = getIntent();
        final Bundle bundle = openDetailsActivity.getExtras();
        url = bundle.getString(URL_KEY);
        name = bundle.getString(NAME_KEY);
        email = bundle.getString(EMAIL_KEY);
        tel = bundle.getString(TEL_KEY);
        lat = bundle.getDouble(LAT_KEY);
        lng = bundle.getDouble(LNG_KEY);
        image = bundle.getInt(IMAGE_KEY);
        description = bundle.getString(DESC_KEY);
        address = bundle.getString(ADDRESS_KEY);
        setPosition(lat, lng);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(position)
                .title(name));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(position)      // Sets the center of the map to Mountain View
                .zoom(17)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private LatLng setPosition(double lat, double lng) {
        position = new LatLng(lat, lng);
        return position;
    }
}
