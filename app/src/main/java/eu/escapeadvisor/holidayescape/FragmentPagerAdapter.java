package eu.escapeadvisor.holidayescape;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.net.MalformedURLException;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    Context mContext;
    String [] tabTitles;

    public FragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        tabTitles = new String[] {mContext.getResources().getString(R.string.category_bars) };

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
                try {
                    return new BarsFragment();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
