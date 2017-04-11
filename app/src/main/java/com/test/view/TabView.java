package com.test.view;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/5.
 */
public class TabView extends LinearLayout implements View.OnClickListener {
    private Context ctx;
    private ViewPager pager;
    private FragmentPagerAdapter adapter;

    private int textSize = 50;
    private int textColorNormal = 0x0000ff;
    private int textColorSelected = 0xff0000;

    private getTitleAndIcon mListener;
    private List<TabItem> listItem = new ArrayList<>();
    private int cilckFlg = 0;//判断是否是点击事件
    private boolean isClick = false;
    public TabView(Context context) {
        super(context);
        ctx = context;
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ctx = context;
    }

    public void setViewpager(ViewPager pager){
        this.pager = pager;
        initPager();
    }

    private void initPager() {
        adapter = (FragmentPagerAdapter) pager.getAdapter();
        if (adapter == null){
            return;
        }
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (isClick){
                    return;
                }
                if (positionOffset>0){
                    listItem.get(position).setAlpha(1 - positionOffset);
                    listItem.get(position + 1).setAlpha(positionOffset);
                }
                else{
                    listItem.get(position).setAlpha(1 - positionOffset);
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (isClick){
                    cilckFlg++;
                    if (cilckFlg == 2){
                        cilckFlg = 0;
                        isClick = false;
                    }
                }
            }

        });
        if (adapter instanceof getTitleAndIcon){
            mListener = (getTitleAndIcon) adapter;
        }
        else {
            throw new RuntimeException("请继承getTitleAndIcon接口");
        }
        initChildView();
    }

    private void initChildView() {
        int size = adapter.getCount();
        for (int i=0;i<size;i++){
            TabItem ti = new TabItem(ctx);
            LayoutParams params = new LayoutParams(0,LayoutParams.WRAP_CONTENT,1);
            ti.setLayoutParams(params);
            ti.setIcon(mListener.getIncon(i));
            ti.setTextColor(textColorNormal,textColorSelected);
            ti.setTextSizeContent(textSize,mListener.getText(i));
            ti.setOnClickListener(this);
            ti.setTag(i);
            ti.setPadding(20,20,20,20);
            listItem.add(ti);
            addView(ti);
        }
    }

    @Override
    public void onClick(View view) {
        isClick = true;
        int position = (int) view.getTag();
        for (TabItem ti : listItem){
            ti.setAlpha(0);
        }
        listItem.get(position).setAlpha(1);
        pager.setCurrentItem(position);
    }

    public interface getTitleAndIcon{
        public int[] getIncon(int position);
        public String getText(int position);
    }
}
