package eu.escapeadvisor.holidayescape;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ErFragment extends Fragment {
    Context mContext;

    public ErFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext  = getContext();
        View rootView = inflater.inflate(R.layout.activity_poi_list, container, false);
        final ArrayList<POI> ers = new ArrayList<>();

        ers.add(new POI(mContext.getResources().getString(R.string.category_er),getString(R.string.er_name1), getString(R.string.er_url1), getString(R.string.er_email1), getString(R.string.er_tel1),
                39.215552, 9.118157, R.drawable.entrapment, getString(R.string.er_desc1),getString(R.string.er_address1) ));
        ers.add(new POI(mContext.getResources().getString(R.string.category_er),getString(R.string.er_name2), getString(R.string.er_url2), getString(R.string.er_email2), getString(R.string.er_tel2),
                39.215552, 9.118157, R.drawable.captivita, getString(R.string.er_desc2),getString(R.string.er_address2) ));

        PoiAdapter ersAdapter = new PoiAdapter(getActivity(), ers);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(ersAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                POI er = (POI) adapterView.getItemAtPosition(i);
                String url = er.getUrl();
                String category = er.getCategory();
                String name = er.getName();
                String email = er.getEmail();
                String tel = er.getTel();
                double lat = er.getLat();
                double lng = er.getLng();
                int image = er.getImage();
                String description = er.getDescription();
                String address = er.getAddress();

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