package com.example.administrator.testproject.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.administrator.testproject.R;
import com.example.administrator.testproject.fragment.FragmentOne;
import com.example.administrator.testproject.fragment.FragmentThree;
import com.example.administrator.testproject.fragment.FragmentTwo;

import org.xutils.common.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutTestActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<String> tabTitle = new ArrayList<>();
    private List<Fragment> listFrg = new ArrayList<>();

    private FragmentOne one;
    private FragmentTwo two;
    private FragmentThree three;

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayouttest);
        fragmentManager = TabLayoutTestActivity.this.getSupportFragmentManager();
        initViews();
        initdata();
        initTab();
    }

    private void initViews() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.tab_viewpager);
    }
    private void initdata(){

        tabTitle.add("tab1");
        tabTitle.add("tab2");
        tabTitle.add("tab3");
        one = new FragmentOne();
        two  = new FragmentTwo();
        three = new FragmentThree();
        listFrg.add(one);
        listFrg.add(two);
        listFrg.add(three);

        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(fpa);
    }

    private void initTab(){
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setSelectedTabIndicatorHeight(5);
//        ViewCompat.setElevation(tabLayout, 10);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());//联动
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
//        tabLayout.getTabAt(0).getCustomView().setSelected(true);
    }

    FragmentPagerAdapter fpa = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return listFrg.get(position);
        }

        @Override
        public int getCount() {
            return listFrg.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle.get(position);
        }
    };

    public class PagerAdapter extends FragmentPagerAdapter {
        private List<String> titles;
        private List<Fragment> fragments;

        public PagerAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments) {
            super(fm);
            this.titles = titles;
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK){
//            List<Fragment> fragments = fragmentManager.getFragments();
//            for(Fragment fragment : fragments){
//                if(fragment != null && fragment.getUserVisibleHint())
//                    LogUtil.d("gggggggggggggg"+fragment.getClass().getSimpleName());
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

}
