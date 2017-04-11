package com.test.view;

import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.testproject.R;

/**
 * Created by Administrator on 2016/7/15.
 */
public class MyShadowView extends View {
    private Paint paint;
    private Bitmap bitmap;
    public MyShadowView(Context context) {
        super(context);
        init();
    }
    public MyShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyShadowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType( LAYER_TYPE_SOFTWARE , null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paint.setShadowLayer(24,2,2,Color.GRAY);
//        paint.setMaskFilter(new BlurMaskFilter(25, BlurMaskFilter.Blur.SOLID));
        paint.setColor(Color.GREEN);
//        paint.setTextSize(80);
//        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.testpic1);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200,300,150,paint);
//        startAnimation();
        ObjectAnimator animator =  ObjectAnimator.ofFloat(new FloatEvaluator(),"translationX",-500f,0f);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                invalidate();
            }
        });
        animator.start();
//        canvas.drawText("董大爷",100,100,paint);
//        canvas.drawBitmap(bitmap,null,new Rect(400,200,400+bitmap.getWidth(),200+bitmap.getHeight()),paint);
    }

    private void startAnimation() {
//        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
//        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                invalidate();
//            }
//        });
        ObjectAnimator anim2 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(),
                "#0000FF", "#FF0000");
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim2);
        animSet.setDuration(5000);
        animSet.start();
    }
}
