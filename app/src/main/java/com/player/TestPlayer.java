package com.player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.testproject.R;
import com.example.myplayerlib.JCVideoPlayerSimple;
import com.example.myplayerlib.JCVideoPlayerStandard;

public class TestPlayer extends AppCompatActivity {

    JCVideoPlayerSimple jcVideoPlayerSimple;
    JCVideoPlayerStandard jcVideoPlayerStandard;
    JCVideoPlayerStandardShowShareButtonAfterFullscreen jcVideoPlayerStandardWithShareButton;
    JCVideoPlayerStandardShowTitleAfterFullscreen jcVideoPlayerStandardShowTitleAfterFullscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_player);
        jcVideoPlayerSimple = (JCVideoPlayerSimple) findViewById(R.id.player);
        jcVideoPlayerSimple.setUp("http://video.jiecao.fm/5/1/%E8%87%AA%E5%8F%96%E5%85%B6%E8%BE%B1.mp4"
                , "嫂子想我没");
    }
}
