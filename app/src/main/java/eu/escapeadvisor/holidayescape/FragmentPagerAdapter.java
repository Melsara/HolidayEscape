package eu.escapeadvisor.holidayescape;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.net.MalformedURLException;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    Context mContext;
    String[] tabTitles;

    public FragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        tabTitles = new String[]{mContext.getResources().getString(R.string.category_bars), mContext.getResources().getString(R.string.category_er),
                mContext.getResources().getString(R.string.category_romanticPlaces), mContext.getResources().getString(R.string.category_culturalPlaces)};

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 1:
                return new ErFragment();

            case 2:
                return new RomanticFragment();

            case 3:
                return new CulturalFragment();
            default:

                return new BarsFragment();
        }

    }

        @Override
        public int getCount () {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle ( int position){
            return tabTitles[position];
        }
    }
