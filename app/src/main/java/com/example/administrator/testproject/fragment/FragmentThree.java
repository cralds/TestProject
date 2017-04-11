package com.example.administrator.testproject.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.testproject.R;

/**
 * Created by Administrator on 2016/8/5.
 */
public class FragmentThree extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        tv.setText("three");
        LinearLayout ll = new LinearLayout(getActivity());
        ll.setBackgroundResource(R.color.red);
        ll.addView(tv);
        return tv;
    }
}
