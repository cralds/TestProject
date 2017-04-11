package com.example.administrator.testproject.TabActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.testproject.R;
import com.example.administrator.testproject.fragment.FragmentOne;
import com.example.administrator.testproject.fragment.FragmentThree;
import com.example.administrator.testproject.fragment.FragmentTwo;
import com.test.view.MyIndicator;
import com.test.view.TabView;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {
    private ViewPager pager;
    private TabView tabView;
    private MyIndicator myIndicator;
    private List<Fragment> listFrg = new ArrayList<>();
    private String[] titleStr = new String[]{"声波购","收藏","我的"};
    private int[] iconSelected = new int[]{R.drawable.home_soundpay_checked,R.drawable.home_collect_checked,R.drawable.home_mine_checked};
    private int[] iconNormal = new int[]{R.drawable.home_soundpay,R.drawable.home_collect,R.drawable.home_mine};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initView();
        initData();
    }

    private void initData() {
        listFrg.add(new FragmentOne());
        listFrg.add(new FragmentTwo());
        listFrg.add(new FragmentThree());
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        tabView.setViewpager(pager);

        myIndicator.setTitle(titleStr);
        myIndicator.setViewpager(pager);
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.viewpager);
        tabView = (TabView) findViewById(R.id.tabView);
        myIndicator = (MyIndicator) findViewById(R.id.myIndicator);
    }
    class MyViewPagerAdapter extends FragmentPagerAdapter implements TabView.getTitleAndIcon {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listFrg.get(position);
        }

        @Override
        public int getCount() {
            return listFrg.size();
        }

        @Override
        public int[] getIncon(int position) {
            int[] result = new int[2];
            result[0] = iconNormal[position];
            result[1] = iconSelected[position];
            return result;
        }

        @Override
        public String getText(int position) {
            return titleStr[position];
        }
    }
}
