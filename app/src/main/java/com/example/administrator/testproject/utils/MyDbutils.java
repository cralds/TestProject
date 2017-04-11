package com.example.administrator.testproject.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * Created by Administrator on 2016/6/24.
 */
public class MyDbutils {
    private DbManager dbManager;
    private DbManager.DaoConfig dbConfigs;
    public DbManager createDB(String dbName, String dbPath, Activity ctx){
        dbConfigs = new DbManager.DaoConfig()
                .setDbDir(new File(dbPath))
                .setDbName(dbName)
                .setDbVersion(0)
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                    }
                });
        dbManager = x.getDb(dbConfigs);
        return dbManager;
    }

}
