package eu.escapeadvisor.holidayescape;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView BarsCat;
    public static int positionTab = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager(), getApplicationContext());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimaryDark));
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorPrimaryLight), getResources().getColor(R.color.colorPrimaryDark));
        tabLayout.getTabAt(positionTab).select();

    }

}
