package com.test.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Administrator on 2016/8/5.
 */
public class TabItem extends View {
    //字体
    private int textSize;
    private String textContent;
    private int textColorNormal;
    private int textColorSelected;
    private Paint textPaintNormal;
    private Paint textPaintSelected;
    //图标
    private Bitmap bitmapIconNormal;
    private Bitmap bitmapIconSelected;
    private Paint iconPaintNormal;
    private Paint iconPaintSelected;

    Rect rectText;//测量字体大小

    public TabItem(Context context) {
        this(context,null);
    }

    public TabItem(Context context, AttributeSet attrs) {
        this(context,null,0);
    }

    public TabItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        rectText = new Rect();
        textPaintNormal = new Paint();
        textPaintNormal.setAntiAlias(true);
        textPaintNormal.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSize, getResources().getDisplayMetrics()));
        textPaintNormal.setColor(textColorNormal);
        textPaintNormal.setAlpha(0xff);

        textPaintSelected = new Paint();
        textPaintSelected.setAntiAlias(true);
        textPaintSelected.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSize, getResources().getDisplayMetrics()));
        textPaintSelected.setColor(textColorSelected);
        textPaintSelected.setAlpha(0x00);

        iconPaintNormal = new Paint();
        iconPaintNormal.setAlpha(0xff);

        iconPaintSelected = new Paint();
        iconPaintSelected.setAlpha(0x00);


    }

    private void MeasureText(){
        textPaintNormal.getTextBounds(textContent,0,textContent.length(),rectText);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widtMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        MeasureText();
        int width = 0;
        int height = 0;
        int contentWidth = Math.max(rectText.width(),bitmapIconNormal.getWidth());
        int totalWidth = contentWidth + getPaddingLeft() + getPaddingRight();
        switch (widtMode){
            case MeasureSpec.AT_MOST://对应wrap_content
                width = totalWidth;
                break;
            case MeasureSpec.EXACTLY://对应match_content
                width = widthSize;
                break;
            case MeasureSpec.UNSPECIFIED://未指定大小
                width = totalWidth;
                break;
        }
        int totalHeight = bitmapIconNormal.getHeight() + rectText.height() + getPaddingTop() + getPaddingBottom();
        switch (heightMode){
            case MeasureSpec.AT_MOST://对应wrap_content
                height = totalHeight;
                break;
            case MeasureSpec.EXACTLY://对应match_content
                height = heightSize;
                break;
            case MeasureSpec.UNSPECIFIED://未指定大小
                height = totalHeight;
                break;
        }
        setMeasuredDimension(width,height);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawText(canvas);
        drawIcon(canvas);
    }

    private void drawIcon(Canvas canvas) {
        int left = (getMeasuredWidth()-bitmapIconNormal.getWidth())/2;
        int top = (getMeasuredHeight() - bitmapIconNormal.getHeight() - rectText.height())/2;
        canvas.drawBitmap(bitmapIconNormal,left,top,iconPaintNormal);
        canvas.drawBitmap(bitmapIconSelected,left,top,iconPaintSelected);
    }

    private void drawText(Canvas canvas) {
        int left = (getMeasuredWidth() - rectText.width())/2;
        int top = (getMeasuredHeight() + bitmapIconNormal.getHeight() + rectText.height())/2;
        canvas.drawText(textContent,left,top,textPaintNormal);
        canvas.drawText(textContent,left,top,textPaintSelected);

    }
    public void setTextColor(int normalColor,int selectedColor){
        this.textColorNormal = normalColor;
        this.textColorSelected = selectedColor;

        textPaintSelected.setColor(textColorSelected);
        textPaintSelected.setAlpha(0);

        textPaintNormal.setColor(textColorNormal);
        textPaintNormal.setAlpha(0xff);
    }
    public void setIcon(int[] icon){
        this.bitmapIconNormal = BitmapFactory.decodeResource(getResources(),icon[0]);
        this.bitmapIconSelected = BitmapFactory.decodeResource(getResources(),icon[1]);
    }
    public void setTextSizeContent(int textSize,String textContent){
        this.textSize = textSize;
        this.textContent = textContent;
        textPaintNormal.setTextSize(textSize);
        textPaintSelected.setTextSize(textSize);
    }
    public void setAlpha(float alpha){
        int mAlpha = (int) (alpha*255);
        textPaintSelected.setAlpha(mAlpha);
        textPaintNormal.setAlpha(255-mAlpha);
        iconPaintSelected.setAlpha(mAlpha);
        iconPaintNormal.setAlpha(255-mAlpha);
        invalidate();
    }
}
