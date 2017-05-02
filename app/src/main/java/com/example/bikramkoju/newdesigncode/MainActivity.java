package com.example.bikramkoju.newdesigncode;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    PagerSlidingTabStrip pagertab;
    ViewPager viewPager;
    BottomBar bottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagertab = (PagerSlidingTabStrip) findViewById(R.id.pager_tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomBar= (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if(tabId == R.id.tab_favorites){
                    Toast.makeText(MainActivity.this,TabMessage.get(tabId, false),Toast.LENGTH_SHORT).show();
                }
                else if (tabId==R.id.tab_nearby){
                    Toast.makeText(MainActivity.this,TabMessage.get(tabId, false),Toast.LENGTH_SHORT).show();
                }
                else if (tabId==R.id.tab_friends) {
                    Toast.makeText(MainActivity.this,TabMessage.get(tabId, false), Toast.LENGTH_SHORT).show();
                }
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                Toast.makeText(getApplicationContext(), TabMessage.get(tabId, true), Toast.LENGTH_LONG).show();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(this, fragmentManager));
        pagertab.setViewPager(viewPager);
    }


    private class MyAdapter extends FragmentStatePagerAdapter {
        Context c;

        public MyAdapter(FragmentActivity mainActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
            c = mainActivity;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TypeA();
                case 1:
                    return new TypeB();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Income";
                case 1:
                    return "Expenses";
            }
            return null;
        }
    }
}
