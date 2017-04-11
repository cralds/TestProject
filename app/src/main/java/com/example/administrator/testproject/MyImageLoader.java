package com.example.administrator.testproject;

import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * Created by Administrator on 2016/6/24.
 */
public class MyImageLoader {
    public void display(ImageView iv,String url,int defaultId){
        ImageOptions imageo = new ImageOptions.Builder()
//                .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))//图片大小
//                .setRadius(DensityUtil.dip2px(5))//ImageView圆角半径
//                .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
//                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setLoadingDrawableId(defaultId)//加载中默认显示图片
                .setFailureDrawableId(defaultId)//加载失败后默认显示图片
                .build();

        x.image().bind(iv,url,imageo);
    }
}
