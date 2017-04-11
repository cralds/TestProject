package com.test.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import org.xutils.common.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ds on 2017/2/20.
 */
public class TestWaveView extends View{
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private Path path1;
    private Path path2,path3;
    private List<Point> list1 = new ArrayList<>();
    private List<Point> list2 = new ArrayList<>();
    private List<Point> list3 = new ArrayList<>();
    public TestWaveView(Context context) {
        this(context,null);
    }

    public TestWaveView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestWaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint1 = new Paint();
        paint1.setColor(Color.RED);
        paint1.setAntiAlias(true);

        paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(10);

        paint3 = new Paint();
        paint3.setColor(Color.GREEN);
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.FILL);

        path1 = new Path();
        path2 = new Path();
        path3 = new Path();

        list1.add(new Point(10,500));
        list1.add(new Point(130,20));
        list1.add(new Point(1000,500));


        list2.add(new Point(10,2000));
        list2.add(new Point(330,520));
        list2.add(new Point(600,2000));
        list2.add(new Point(1200,750));

//        list3.add(new Point(DensityUtil.dip2px(300),DensityUtil.dip2px(200)));
//        list3.add(new Point(DensityUtil.dip2px(350),DensityUtil.dip2px(250)));
//        list3.add(new Point(DensityUtil.dip2px(170),DensityUtil.dip2px(300)));//中间控制点
//        list3.add(new Point(DensityUtil.dip2px(50),DensityUtil.dip2px(400)));
//        list3.add(new Point(DensityUtil.dip2px(100),DensityUtil.dip2px(450)));
        list3.add(new Point(DensityUtil.dip2px(100),DensityUtil.dip2px(200)));
        list3.add(new Point(DensityUtil.dip2px(300),DensityUtil.dip2px(200)));
        list3.add(new Point(DensityUtil.dip2px(200),DensityUtil.dip2px(350)));//中间控制点
        list3.add(new Point(DensityUtil.dip2px(100),DensityUtil.dip2px(500)));
        list3.add(new Point(DensityUtil.dip2px(300),DensityUtil.dip2px(500)));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path1.moveTo(list1.get(0).getX(),list1.get(0).getY());
        path1.quadTo(list1.get(1).getX(),list1.get(1).getY(),list1.get(2).getX(),list1.get(2).getY());
        path1.lineTo(list1.get(2).getX(),list1.get(2).getY());
        path1.lineTo(1200,800);
        path1.lineTo(1400,700);
        canvas.drawPath(path1,paint1);


        path2.moveTo(list2.get(0).getX(),list2.get(0).getY());
        path2.cubicTo(list2.get(1).getX(),list2.get(1).getY(),list2.get(2).getX(),list2.get(2).getY(),
                list2.get(3).getX(),list2.get(3).getY());
        canvas.drawPath(path2,paint2);

        path3.moveTo(list3.get(0).getX(),list3.get(0).getY());
        path3.quadTo(list3.get(2).getX(),list3.get(2).getY(),list3.get(3).getX(),list3.get(3).getY());
        path3.lineTo(list3.get(4).getX(),list3.get(4).getY());
        path3.quadTo(list3.get(2).getX(),list3.get(2).getY(),list3.get(1).getX(),list3.get(1).getY());
        canvas.drawPath(path3,paint3);
    }
    class Point{
        private float x;
        private float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getX() {
            return x;
        }

        public void setY(float y) {
            this.y = y;
        }

        public float getY() {
            return y;
        }
    }
}
