package com.example.administrator.testproject.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by ds on 2016/11/8.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{

        protected Collection<T> mDatas;
        protected Context mCtx;
        protected LayoutInflater mInflater;
        private boolean isScrolling;
        protected OnItetmClickListener onItemClickListener;
        protected Integer mLayoutId;
//    private ViewAnimator mViewAnimator;


        public BaseAdapter(Context ctx, Collection<T> datas) {
            if (datas == null) {
                datas = new ArrayList<T>(0);
            }

            this.mDatas = datas;
            this.mInflater = LayoutInflater.from(ctx);
            this.mCtx = ctx;
//        mViewAnimator = new ViewAnimator(mCtx);

        }

        public BaseAdapter(Context ctx, Collection<T> mDatas, @LayoutRes Integer layoutId) {
            this(ctx, mDatas);
            this.mLayoutId = layoutId;
        }

        @Override
        public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(mLayoutId, parent, false);
            BaseViewHolder holder = new BaseViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final BaseViewHolder holder, final int position) {
            if (onItemClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(holder.itemView, getItem(position), position);
                    }
                });
            }
            onBindViewHolder(holder, getItem(position), isScrolling, position);
//        animateView(holder.itemView, position);
        }

        /**
         * Animates given View
         *
         * @param position the position of the item the View represents.
         * @param view     the View that should be animated.
         */
        private void animateView(final View view, final int position) {
//        assert mViewAnimator != null;

//        Animator[] animators = getAnimators(view);
//        Animator alphaAnimator = ObjectAnimator.ofFloat(view, ALPHA, 0, 1);
//        Animator[] concatAnimators = AnimatorUtil.concatAnimators(animators, alphaAnimator);
//        mViewAnimator.animateViewIfNecessary(position, view, concatAnimators);
        }

//    protected abstract Animator[] getAnimators(View view);

        protected abstract void onBindViewHolder(BaseViewHolder holder, T item, boolean isScrolling, int position);

        /**
         * add item enter animtor
         *
         * @param view need to set animator
         */
        protected void additemAnimation(View view) {
        }

        ;

        public T getItem(int position) {
            if (mDatas instanceof List) {
                return ((List<T>) mDatas).get(position);
            } else if (mDatas instanceof Set) {
                return new ArrayList<T>(mDatas).get(position);
            } else {
                return null;
            }
        }

        @Override
        public int getItemCount() {
            return mDatas == null ? 0 : mDatas.size();
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        public interface OnItetmClickListener<E> {
            public void onItemClick(View view, E item, int position);
        }

        public void setOnItemClickListener(OnItetmClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }


}
