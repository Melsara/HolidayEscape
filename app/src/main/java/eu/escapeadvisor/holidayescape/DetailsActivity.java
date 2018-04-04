package eu.escapeadvisor.holidayescape;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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

public class DetailsActivity extends Activity {

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
}
