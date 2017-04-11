package com.example.administrator.testproject.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.xutils.common.util.DensityUtil;

/**
 * 卡片描述
 * Created by peter on 2016/10/20.
 */

public class CardItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int count = parent.getAdapter().getItemCount();
        if (parent.getChildAdapterPosition(view) < count - 1) {
            outRect.set(0, 0, 0, -DensityUtil.dip2px(130));
        }
    }
}
