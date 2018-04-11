package eu.escapeadvisor.holidayescape;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class RomanticFragment extends Fragment {
    Context mContext;
    int positionTab = 2;

    public RomanticFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext  = getContext();
        View rootView = inflater.inflate(R.layout.activity_poi_list, container, false);
        final ArrayList<POI> romantics = new ArrayList<>();

        romantics.add(new POI(mContext.getResources().getString(R.string.category_romanticPlaces),getString(R.string.rom_name1), getString(R.string.rom_url1), getString(R.string.rom_email1), getString(R.string.rom_tel1),
                39.234325, 9.115732, R.drawable.monteclaro, getString(R.string.rom_desc1),getString(R.string.rom_address1) ));
        romantics.add(new POI(mContext.getResources().getString(R.string.category_romanticPlaces),getString(R.string.rom_name2), getString(R.string.rom_url2), getString(R.string.rom_email2), getString(R.string.rom_tel2),
                39.212952, 9.171051, R.drawable.poetto, getString(R.string.rom_desc2),getString(R.string.rom_address2) ));
        romantics.add(new POI(mContext.getResources().getString(R.string.category_romanticPlaces),getString(R.string.rom_name3), getString(R.string.rom_url3), getString(R.string.rom_email3), getString(R.string.rom_tel3),
                39.216157, 9.134601, R.drawable.urpinu, getString(R.string.rom_desc3),getString(R.string.rom_address3) ));
        romantics.add(new POI(mContext.getResources().getString(R.string.category_romanticPlaces),getString(R.string.rom_name4), getString(R.string.rom_url4), getString(R.string.rom_email4), getString(R.string.rom_tel4),
                39.218825, 9.114728, R.drawable.croce, getString(R.string.rom_desc4),getString(R.string.rom_address4) ));

        PoiAdapter romanticsAdapter = new PoiAdapter(getActivity(), romantics);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(romanticsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                POI romantics = (POI) adapterView.getItemAtPosition(i);
                String url = romantics.getUrl();
                String category = romantics.getCategory();
                String name = romantics.getName();
                String email = romantics.getEmail();
                String tel = romantics.getTel();
                double lat = romantics.getLat();
                double lng = romantics.getLng();
                int image = romantics.getImage();
                String description = romantics.getDescription();
                String address = romantics.getAddress();

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
                bundle.putInt(GlobalConstants.POSITION_KEY, positionTab);
                openBarDetail.putExtras(bundle);
                startActivity(openBarDetail);

            }
        });

        return rootView;
    }

}
