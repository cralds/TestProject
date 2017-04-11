package com.example.administrator.testproject.adapter;

import android.graphics.Bitmap;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ds on 2016/11/8.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> mViews;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<View>();
    }

    /**
     * 拿到全部View
     *
     * @return all inflated View
     */
    public SparseArray<View> getAllView() {
        return mViews;
    }

    public View getConvertView() {
        return itemView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId ViewId
     * @return all inflated view
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * set TextView text
     *
     * @param viewId viewId
     * @param text   text
     * @return BaseViewHolder
     */
    public BaseViewHolder setText(int viewId, CharSequence text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 设置文字大小
     *
     * @param viewId   viewId
     * @param textSize 文字大小
     * @return BaseViewHolder
     */
    public BaseViewHolder setTextSize(int viewId, float textSize) {
        TextView view = getView(viewId);
        view.setTextSize(textSize);
        return this;
    }

    /**
     * 设置文字颜色
     *
     * @param viewId viewId
     * @param color  文字颜色
     * @return BaseViewHolder
     */
    public BaseViewHolder setTextColor(int viewId, @ColorInt int color) {
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }

    public BaseViewHolder setChecked(@IdRes int viewId, boolean checked) {
        Checkable view = getView(viewId);
        view.setChecked(checked);
        return this;
    }

    public BaseViewHolder setVisibility(@IdRes int viewId, int visibility) {
        View view = getView(viewId);
        view.setVisibility(visibility);
        return this;
    }

    /**
     * set ImageViewͼID
     *
     * @param viewId     viewId
     * @param drawableId drawableId
     * @return BaseViewHolder
     */
    public BaseViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * set ImageViewͼ
     *
     * @param viewId viewId
     * @param bm     ͼƬ
     * @return BaseViewHolder
     */
    public BaseViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener clickListener) {
        View view = getView(viewId);
        view.setOnClickListener(clickListener);
        return this;
    }

}
