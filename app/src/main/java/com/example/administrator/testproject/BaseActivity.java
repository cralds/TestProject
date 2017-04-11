package com.example.administrator.testproject;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.example.administrator.testproject.utils.MyDbutils;

import org.xutils.DbManager;

/**
 * Created by Administrator on 2016/6/28.
 */
public class BaseActivity extends Activity{
    public DbManager dbManager;
    public void InitDbUtils(){
        //申请权限
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permission Granted
            Toast.makeText(this,"允许",Toast.LENGTH_SHORT).show();
            dbManager = new MyDbutils().createDB("testDb.db","/sdcard/",this);
        } else {
            // Permission Denied
            Toast.makeText(this,"拒绝",Toast.LENGTH_SHORT).show();
        }
    }
}
