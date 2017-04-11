package com.example.administrator.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.testproject.Activity.BLineActivity;
import com.example.administrator.testproject.Activity.TabLayoutTestActivity;
import com.example.administrator.testproject.Activity.TestCardTwoActivity;
import com.example.administrator.testproject.Activity.AppToolbarActivity;
import com.example.administrator.testproject.TabActivity.TabActivity;
import com.example.administrator.testproject.adapter.MainActAdapter;
import com.player.TestPlayer;

import java.util.ArrayList;
import java.util.List;

public class LaunchActivity extends AppCompatActivity {
    private ListView listv;
    private MainActAdapter adapter;

    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        initViews();
    }

    private void initViews() {
        listv = (ListView) findViewById(R.id.listv_showMsg);
        initListener();

        initData();

        dataChanged();
    }

    private void initData() {
        data.add("简单自定义控件动画");
        data.add("自定义tab仿微信加meterial design控件");
        data.add("播放器");
        data.add("recycleView卡片效果");
        data.add("cardstackview卡片效果");
        data.add("AppBarLayout+toolbar");
        data.add("tablayout");
        data.add("贝塞尔曲线");

    }

    private void initListener(){
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        startActivity(new Intent(LaunchActivity.this,MainActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(LaunchActivity.this,TabActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(LaunchActivity.this,TestPlayer.class));
                        break;
                    case 3:
                        startActivity(new Intent(LaunchActivity.this,CardRecycleActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(LaunchActivity.this,TestCardTwoActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(LaunchActivity.this,AppToolbarActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(LaunchActivity.this,TabLayoutTestActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(LaunchActivity.this, BLineActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void dataChanged(){
        if (adapter == null){
            adapter = new MainActAdapter(data,this);
            listv.setAdapter(adapter);
        }
        else {
            adapter.notifyDataSetChanged();
        }
    }
}
