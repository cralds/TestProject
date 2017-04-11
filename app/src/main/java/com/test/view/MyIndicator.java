package com.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.common.util.LogUtil;

/**
 * Created by Administrator on 2016/8/9.
 */
public class MyIndicator extends LinearLayout {
    private Context context;
    private int indicatorHeight = 5;//默认下划线高度
    private int indicatorColor=0xff0000;//下划线颜色
    private ViewPager pager;

    private Paint paintIndicator;
    private Paint textPaint;
    private String[] strTitle;//title
    private int textSize = 12;
    private int textColorNormal;
    private int textColorSelected;
    private int width,height,left;
    private Rect rectText;//title框，方便计算宽高

    public MyIndicator(Context context) {
        this(context,null);
    }

    public MyIndicator(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.TRANSPARENT);  // 必须设置背景，否则onDraw不执行
        this.context = context;
        init();
    }

    private void init() {
        rectText = new Rect();
        paintIndicator = new Paint();
        paintIndicator.setColor(Color.RED);
        paintIndicator.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setTextSize(50);
        textPaint.setAntiAlias(true);
    }

    public void setViewpager(ViewPager pager){
        this.pager = pager;
        initPager();
    }

    private void initPager() {
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    drawIndicator(position,positionOffset);
                LogUtil.d("SSSSSSSSSSSSSSSs"+position+"       "+positionOffset);
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void measureText(){
        textPaint.getTextBounds("测试",0,"测试".length(),rectText);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        measureText();
        height = rectText.height() + getPaddingBottom()+getPaddingTop();
        width = widthSize;
        setMeasuredDimension(widthSize,height+indicatorHeight);
    }

    public void setTitle(String[] title){
        this.strTitle = title;
        LayoutParams params = new LayoutParams(0, LayoutParams.WRAP_CONTENT,1);
        for (int i=0;i<title.length;i++){
            TextView tv = new TextView(context);
            tv.setText(strTitle[i]);
            tv.setTextSize(12);
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
            tv.setLayoutParams(params);
            addView(tv);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (strTitle !=null && strTitle.length>0){
            Rect rect = new Rect(left,height,left+width/strTitle.length,height+indicatorHeight);
            canvas.drawRect(rect,paintIndicator);
        }
    }
    public void drawIndicator(int position,float positionOffset){
        left = (int) (width/strTitle.length * (position + positionOffset));
        invalidate();
    }
}
