package com.example.administrator.testproject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    private ImageView iv,ivProgress;
    private TextView tv;
    private MyShadowView shadowView;
    private boolean isOpen = false;

    private int flag = 0;
    private List<Parent> list = new ArrayList<>();
    private int height = 0,width = 0;
    ObjectAnimator scaleXAnimator;
    ValueAnimator scaleY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivProgress = (ImageView) findViewById(R.id.ivProgress);
        rippleBackground = (RippleBackground) findViewById(R.id.ripple);
        iv = (ImageView) findViewById(R.id.iv_soundpay);
        tv = (TextView) findViewById(R.id.tv_hello);
        shadowView = (MyShadowView) findViewById(R.id.myshowview);
        ObjectAnimator animator =  ObjectAnimator.ofFloat(tv,"rotation",0f,360f);
//        animator.setInterpolator(new OvershootInterpolator());


        final ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(tv, "ScaleY", 0.5f, 1.0f);
        final TranslateAnimation ta = new TranslateAnimation(-10,10,0,0);
        ta.setDuration(300);
        ta.setInterpolator(new CycleInterpolator(3));





        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (height == 0){
                    height = tv.getHeight();
                    width = tv.getWidth();
                    scaleY = ValueAnimator.ofInt(width, height); ////第二个高度 需要注意一下, 因为view默认是GONE  无法直接获取高度
                    scaleY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int animatorValue = Integer.valueOf(animation.getAnimatedValue() + "");
                            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();
                            params.width = animatorValue;
                            tv.setLayoutParams(params);
                        }
                    });
                    scaleY.setTarget(tv);
                    scaleY.setDuration(1000);
                }
                else {
                    scaleY = ValueAnimator.ofInt(height, width); ////第二个高度 需要注意一下, 因为view默认是GONE  无法直接获取高度
                    scaleY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int animatorValue = Integer.valueOf(animation.getAnimatedValue() + "");
                            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();
                            params.width = animatorValue;
                            tv.setLayoutParams(params);
                        }
                    });
                    scaleY.setTarget(tv);
                    scaleY.setDuration(1000);
                }
//                tv.startAnimation(ta);
//                scaleXAnimator.start();
                scaleY.start();
            }
        });

//        AnimatorSet animSet = new AnimatorSet();
//        animSet.play(animator).with(scaleXAnimator).with(scaleYAnimator);
//        animSet.setDuration(2000);
//        animSet.start();

//        startActivity(new Intent(this, TabActivity.class));
        final ScaleAnimation sa = new ScaleAnimation(1.2f,1f,1.2f,1f
                ,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(500);

        InitDbUtils();
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.startAnimation(sa);
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
