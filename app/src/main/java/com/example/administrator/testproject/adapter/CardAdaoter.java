package com.example.administrator.testproject.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.View;


import com.example.administrator.testproject.R;
import com.test.view.LoadingImageView;

import java.util.Collection;


/**
 * 首页卡片适配器
 * Created by peter on 2016/10/20.
 */

public class CardAdaoter extends BaseAdapter<String> {


    public CardAdaoter(Context ctx, Collection<String> mDatas, @LayoutRes Integer layoutId) {
        super(ctx, mDatas, layoutId);
    }

    @Override
    protected void onBindViewHolder(BaseViewHolder holder, String item, boolean isScrolling, int position) {
        LoadingImageView ivImg = holder.getView(R.id.adapter_swipe_cardImg);
        ivImg.setShowProgress(false);
        ivImg.setImageResource(R.drawable.card_defaultcard);

        ivImg.setCardNum("0000 8888");
        holder.setVisibility(R.id.adapter_swipe_ivIsdefault, position==1 ? View.VISIBLE : View.GONE);
    }
}
