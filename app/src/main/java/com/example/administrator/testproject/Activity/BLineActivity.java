package com.example.administrator.testproject.Activity;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Looper;
import android.support.design.widget.Snackbar;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;

import com.example.administrator.testproject.R;
import com.example.administrator.testproject.helper.WaveHelper;
import com.test.view.MyWaveView;
import com.test.view.WaveProgressView;

public class BLineActivity extends AppCompatActivity {
    private ImageView iv;
    private ValueAnimator animator;
    private MyWaveView mWaveView;
    private WaveProgressView waveProgressView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bline);
        iv = (ImageView) findViewById(R.id.bline_iv);
        iv.setX(10);
        iv.setY(2000);

        animator =  ValueAnimator.ofObject(new MyBesaierLine(),new PointF(10,2000),new PointF(1200,750));
        animator.setRepeatCount(5);
        animator.setDuration(3000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setInterpolator(new AnticipateOvershootInterpolator());
        animator.setTarget(iv);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                iv.setX(pointF.x);
                iv.setY(pointF.y);
            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animator.start();
            }
        });
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });

        mWaveView = (MyWaveView) findViewById(R.id.wave_view);
        mWaveView.setDuration(5000);
        mWaveView.setStyle(Paint.Style.FILL);
        mWaveView.setColor(Color.parseColor("#ff0000"));
        mWaveView.setInterpolator(new LinearOutSlowInInterpolator());
        mWaveView.start();


        waveProgressView = (WaveProgressView) findViewById(R.id.waveprogressView);
        WaveHelper helper = new WaveHelper(waveProgressView);
        helper.start();
    }


    class MyBesaierLine implements TypeEvaluator<PointF>{
        @Override
        public PointF evaluate(float t, PointF pointF, PointF t1) {
            PointF result = new PointF();
            float mt = 1.0f - t;

            PointF p0 = pointF;

            PointF p1 = new PointF(330,520);
            PointF p2 = new PointF(600,2000);

            PointF p3 = t1;

            result.x = mt * mt * mt * (p0.x)
                    + 3 * mt * mt * t * (p1.x)
                    + 3 * mt * t * t * (p2.x)
                    + t * t * t * (p3.x);

            result.y = mt * mt * mt * (p0.y)
                    + 3 * mt * mt * t * (p1.y)
                    + 3 * mt * t * t * (p2.y)
                    + t * t * t * (p3.y);

            return result;
        }
    }
}
