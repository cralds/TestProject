package com.example.administrator.testproject;

import android.app.Application;

import com.rey.material.app.ThemeManager;

import org.xutils.x;

import cn.passguard.PassGuardEdit;

/**
 * Created by Administrator on 2016/6/21.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
        ThemeManager.init(this, 2, 0, null);
        PassGuardEdit.setLicense("cXBBYzVEKzhsODJvVExKcnRxRDBiU1QvVlNYR1JLK090RjNSR1hTTnNRdWM1MmhSZ0dQQXU5Ukt2bEJONzVNd1Y4UGI1aFZFRHhxbmg4R3J4YXBON2tBS1BJRkhQTHdwSWZGMmFLdXREbkpNc3psVWNpYTBEK1AzejA1MW9WL1U2ZzBaYVg4Q2lnR1hOa3czVWlCN0JJUE1ZdVhHLzFad0FweE9qaVEwbXF3PXsiaWQiOjAsInR5cGUiOiJwcm9kdWN0IiwicGFja2FnZSI6WyJjb20uenRlLnNtYXJ0cGF5Il0sImFwcGx5bmFtZSI6WyLkuK3lhbTku5giXSwicGxhdGZvcm0iOjJ9");// 重要

    }
}
