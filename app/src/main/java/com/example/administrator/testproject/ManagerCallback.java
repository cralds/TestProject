package com.example.administrator.testproject;

import org.xutils.common.Callback;

/**
 * Created by Administrator on 2016/6/28.
 */
public abstract class ManagerCallback<T> {
    /**
     * Http请求回调
     * @author Administrator
     * @param <T>
     */

        /**
         * 请求成功
         * @param returnContent 请求返回结果
         */
        public void onSuccess(T returnContent) {
        };

        /**
         * 请求失败
         * @param msg 消息
         */
        public void onFailure(String msg) {
        };

        /**
         * 进度条更新
         */
        public void onProgress(long total, long current, boolean isUploading) {
        };

    /**
     * 取消网络请求
     * @param cex
     */
        public void onCancelled(Callback.CancelledException cex) { };
    }
