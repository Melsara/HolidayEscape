package eu.escapeadvisor.holidayescape;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
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
    private int lat;
    private int lng;
    private int image;
    private String description;
    private String address;

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
        lat = bundle.getInt(LAT_KEY);
        lng = bundle.getInt(LNG_KEY);
        image = bundle.getInt(IMAGE_KEY);
        description = bundle.getString(DESC_KEY);
        address = bundle.getString(ADDRESS_KEY);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));
    }
}
