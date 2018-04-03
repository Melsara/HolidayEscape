package eu.escapeadvisor.holidayescape;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PoiAdapter extends ArrayAdapter<POI>{

    private int mColorResourceId;

    public PoiAdapter (Activity context, ArrayList<POI> pois, int colorResourceId){
        super(context, 0, pois);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        POI currentPoi = getItem(position);

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

/*        TextView categoryTextView = (TextView) listItemView.findViewById(R.id.category_textView);
        categoryTextView.setText(currentPoi.getCategory());*/
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_textView);
        nameTextView.setText(currentPoi.getName());
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_textView);
        addressTextView.setText(currentPoi.getAddress());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageView);

/*        View textRoot = listItemView.findViewById(R.id.textRoot);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textRoot.setBackgroundColor(color);*/

        return listItemView;
    }
}
