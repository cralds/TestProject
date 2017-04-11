package com.example.administrator.testproject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.testproject.TabActivity.TabActivity;
import com.example.administrator.testproject.bean.ErrorBean;
import com.example.administrator.testproject.bean.Parent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.view.MyShadowView;
import com.test.view.RippleBackground;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends BaseActivity {

    private RippleBackground rippleBackground;
    private ImageView iv;
    private TextView tv;
    private MyShadowView shadowView;
    private boolean isOpen = false;

    private int flag = 0;
    private List<Parent> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rippleBackground = (RippleBackground) findViewById(R.id.ripple);
        iv = (ImageView) findViewById(R.id.iv_soundpay);
        tv = (TextView) findViewById(R.id.tv_hello);
        shadowView = (MyShadowView) findViewById(R.id.myshowview);
        ObjectAnimator animator =  ObjectAnimator.ofFloat(tv,"rotation",0f,360f);
//        animator.setInterpolator(new OvershootInterpolator());

        final ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(tv, "ScaleX", 0.5f, 1.0f);
        final ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(tv, "ScaleY", 0.5f, 1.0f);

        AnimatorSet animSet = new AnimatorSet();
        animSet.play(animator).with(scaleXAnimator).with(scaleYAnimator);
        animSet.setDuration(2000);
        animSet.start();

//        startActivity(new Intent(this, TabActivity.class));
        InitDbUtils();
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isOpen){
                    rippleBackground.startRippleAnimation();
                    isOpen = true;

                    Parent parent = new Parent();
                    parent.setAge(20+flag);
                    parent.setName("parent"+flag);
                }
                else {
                    rippleBackground.stopRippleAnimation();
                    isOpen = false;
                }
            }
        });
    }

}
