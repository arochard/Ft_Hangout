package com.a42.arochard.hangout.ViewPager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.a42.arochard.hangout.Fragment.ChatFragment;
import com.a42.arochard.hangout.Fragment.ContactFragment;
import com.a42.arochard.hangout.R;
import com.a42.arochard.hangout.ViewPagerAdapter;

/**
 * Created by arochard on 6/6/17.
 */

public class TabActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter adapter;

    ChatFragment chatFragment;
    ContactFragment contactFragment;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        //initialize viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);
        setupViewPager(viewPager);

        //initialize tabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab){

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab){

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(this, "Home settings click", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupViewPager(ViewPager vp)
    {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        chatFragment = new ChatFragment();
        contactFragment = new ContactFragment();
        adapter.addFragment(contactFragment, "CONTACTS");
        adapter.addFragment(chatFragment, "CHATS");
        viewPager.setAdapter(adapter);

    }
}
