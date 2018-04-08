package eu.escapeadvisor.holidayescape;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BarsFragment extends Fragment {

    Context mContext;


    public BarsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getContext();
        View rootView = inflater.inflate(R.layout.activity_poi_list, container, false);
        final ArrayList<POI> bars = new ArrayList<>();

        bars.add(new POI(mContext.getResources().getString(R.string.category_bars),getString(R.string.bar_name1), getString(R.string.bar_url1), getString(R.string.bar_email1), getString(R.string.bar_tel1),
                39.219303, 9.106513, R.drawable.gaucho, getString(R.string.bar_desc1),getString(R.string.bar_address1)));
        bars.add(new POI(mContext.getResources().getString(R.string.category_bars),getString(R.string.bar_name2), getString(R.string.bar_url2), getString(R.string.bar_email2), getString(R.string.bar_tel2),
                39.221331, 9.136219, R.drawable.bamboo, getString(R.string.bar_desc2),getString(R.string.bar_address2)));

        PoiAdapter barsAdapter = new PoiAdapter(getActivity(), bars);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(barsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                POI bar = (POI) adapterView.getItemAtPosition(i);
                String url = bar.getUrl();
                String category = bar.getCategory();
                String name = bar.getName();
                String email = bar.getEmail();
                String tel = bar.getTel();
                double lat = bar.getLat();
                double lng = bar.getLng();
                int image = bar.getImage();
                String description = bar.getDescription();
                String address = bar.getAddress();

                Intent openBarDetail = new Intent(getContext(), DetailsActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString(GlobalConstants.URL_KEY, url);
                bundle.putString(GlobalConstants.NAME_KEY, name);
                bundle.putString(GlobalConstants.EMAIL_KEY, email);
                bundle.putString(GlobalConstants.TEL_KEY, tel);
                bundle.putDouble(GlobalConstants.LAT_KEY, lat);
                bundle.putDouble(GlobalConstants.LNG_KEY, lng);
                bundle.putInt(GlobalConstants.IMAGE_KEY, image);
                bundle.putString(GlobalConstants.DESC_KEY, description);
                bundle.putString(GlobalConstants.ADDRESS_KEY, address);
                openBarDetail.putExtras(bundle);
                startActivity(openBarDetail);
            }
        });

        return rootView;
    }

}
