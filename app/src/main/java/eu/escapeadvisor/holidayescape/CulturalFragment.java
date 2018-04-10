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

/**
 * A simple {@link Fragment} subclass.
 */
public class CulturalFragment extends Fragment {
    Context mContext;

    public CulturalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext  = getContext();
        View rootView = inflater.inflate(R.layout.activity_poi_list, container, false);
        final ArrayList<POI> culturals = new ArrayList<>();

        culturals.add(new POI(mContext.getResources().getString(R.string.category_culturalPlaces),getString(R.string.cult_name1), getString(R.string.cult_url1),
                getString(R.string.cult_email1), getString(R.string.cult_tel1),39.222399, 9.116647, R.drawable.arch, getString(R.string.cult_desc1),getString(R.string.cult_address1)));
        culturals.add(new POI(mContext.getResources().getString(R.string.category_culturalPlaces),getString(R.string.cult_name2), getString(R.string.cult_url2),
                getString(R.string.cult_email2), getString(R.string.cult_tel2),39.244441, 9.109616, R.drawable.michele, getString(R.string.cult_desc2),getString(R.string.cult_address2)));
        culturals.add(new POI(mContext.getResources().getString(R.string.category_culturalPlaces),getString(R.string.cult_name3), getString(R.string.cult_url3),
                getString(R.string.cult_email3), getString(R.string.cult_tel3),39.224262, 9.121482, R.drawable.ghost, getString(R.string.cult_desc3),getString(R.string.cult_address3)));
        culturals.add(new POI(mContext.getResources().getString(R.string.category_culturalPlaces),getString(R.string.cult_name4), getString(R.string.cult_url4),
                getString(R.string.cult_email4), getString(R.string.cult_tel4),39.221315, 9.109939, R.drawable.botanico, getString(R.string.cult_desc4),getString(R.string.cult_address4)));

        PoiAdapter culturalsAdapter = new PoiAdapter(getActivity(), culturals);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(culturalsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                POI cult = (POI) adapterView.getItemAtPosition(i);
                String url = cult.getUrl();
                String category = cult.getCategory();
                String name = cult.getName();
                String email = cult.getEmail();
                String tel = cult.getTel();
                double lat = cult.getLat();
                double lng = cult.getLng();
                int image = cult.getImage();
                String description = cult.getDescription();
                String address = cult.getAddress();

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
