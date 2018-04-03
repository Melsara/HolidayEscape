package eu.escapeadvisor.holidayescape;


import android.content.Context;
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
    URL url1 = new URL("http://www.google.com/");
    Context mContext;

    public ErFragment() throws MalformedURLException {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext  = getContext();
        View rootView = inflater.inflate(R.layout.activity_poi_list, container, false);
        final ArrayList<POI> ers = new ArrayList<>();

        ers.add(new POI(mContext.getResources().getString(R.string.category_er),"ER1", url1, "email", "000000000",
                0, 0, R.drawable.ic_launcher_background, "Lorem ipsum","address" ));

        PoiAdapter ersAdapter = new PoiAdapter(getActivity(), ers);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(ersAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;
    }

}