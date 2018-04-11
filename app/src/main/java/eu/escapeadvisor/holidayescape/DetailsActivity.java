package eu.escapeadvisor.holidayescape;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static eu.escapeadvisor.holidayescape.GlobalConstants.ADDRESS_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.DESC_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.EMAIL_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.IMAGE_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.LAT_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.LNG_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.NAME_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.POSITION_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.TEL_KEY;
import static eu.escapeadvisor.holidayescape.GlobalConstants.URL_KEY;

public class DetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

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

        /*Calling back on actionBar*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            // Loading map
            initializeMap();

        } catch (Exception e) {
            e.printStackTrace();
        }


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
        MainActivity.positionTab = bundle.getInt(POSITION_KEY);
        setPosition(lat, lng);
        setContentView();
    }

    private void initializeMap () {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private LatLng setPosition(double lat, double lng) {
        position = new LatLng(lat, lng);
        return position;
    }

    private void setContentView (){
        TextView textView_name = findViewById(R.id.textView_name);
        textView_name.setText(name);
        TextView textView_url = findViewById(R.id.textView_web);
        textView_url.setText(url);
        TextView textView_email = findViewById(R.id.textView_email);
        textView_email.setText(email);
        TextView textView_tel = findViewById(R.id.textView_tel);
        textView_tel.setText(tel);
        TextView textView_address = findViewById(R.id.textView_address);
        textView_address.setText(address);
        TextView textView_description = findViewById(R.id.textView_desc);
        textView_description.setText(description);
        ImageView imageView_image = findViewById(R.id.imageView_image);
        imageView_image.setImageResource(image);
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
        map.getUiSettings().setZoomGesturesEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.getUiSettings().setRotateGesturesEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeMap();
    }
}
