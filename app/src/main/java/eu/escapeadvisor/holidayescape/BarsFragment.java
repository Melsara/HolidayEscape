package eu.escapeadvisor.holidayescape;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarsFragment extends Fragment {

    URL url1 = new URL("http://www.google.com/");


    public BarsFragment() throws MalformedURLException {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_poi_list, container, false);
        final ArrayList<POI> bars = new ArrayList<>();

        bars.add(new POI("Bar","title1", url1, "email", "000000000",
                        0, 0, R.drawable.ic_launcher_background, "Lorem ipsum","address" ));

        PoiAdapter barsAdapter = new PoiAdapter(getActivity(), bars, R.color.colorPrimary);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(barsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;
    }

}
