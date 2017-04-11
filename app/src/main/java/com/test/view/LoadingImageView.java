package com.test.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.administrator.testproject.R;

import org.xutils.common.util.DensityUtil;


/**
 * Created by Jiang on 2016/10/3.
 */

public class LoadingImageView extends ImageView {

    private int current;
    private int maxProgress = 100;
    private Paint paint;
    private boolean isShowProgress = true;
    private boolean isFirst = true;
    private Paint textPaint;
    private String cardNum = "";

    public LoadingImageView(Context context) {
        this(context, null);
    }

    public LoadingImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xb3b2b3);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(DensityUtil.dip2px(20));
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getMeasuredWidth();
        int h = getMeasuredHeight();
        if (!TextUtils.isEmpty(cardNum)) {
            canvas.drawText(cardNum, DensityUtil.dip2px(25), h - DensityUtil.dip2px(35), textPaint);
        }
        if (isShowProgress) {

            int alpha = (int) (250.0f * (maxProgress - current) / maxProgress);
            if (alpha > 240) {
                alpha = 235;
            }
            paint.setAlpha(alpha);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                canvas.drawRoundRect(0, 0, w, h, ImageLoder.RADIUS, ImageLoder.RADIUS, paint);
//            } else {
                canvas.drawRect(0, 0, w, h, paint);
//            }
        }
    }

    public void setProgress(int current) {
        if (current < 0) {
            current = 0;
        }
        if (current > maxProgress) {
            current = maxProgress;
        }
        this.current = current;
        invalidate();
    }

    public int getProgress() {
        return current;
    }

    public void setShowProgress(boolean showProgress) {
        isShowProgress = showProgress;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.card_defaultcard, options);
        float ratioWH = (float) options.outWidth / options.outHeight;

        int widthSize = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                widthSize = MeasureSpec.getSize(widthMeasureSpec);
                break;
            default:
                widthSize = options.outWidth;
                break;
        }

        int heightSize = (int) (widthSize / ratioWH);


        setMeasuredDimension(widthSize, heightSize);
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
        invalidate();
    }
}
