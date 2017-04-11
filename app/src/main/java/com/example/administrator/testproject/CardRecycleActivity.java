package com.example.administrator.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.testproject.adapter.CardAdaoter;
import com.example.administrator.testproject.utils.CardItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class CardRecycleActivity extends AppCompatActivity {

    private RecyclerView card_list_view;
    private CardAdaoter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recycle);
        initViews();
    }

    private void initViews() {
        card_list_view = (RecyclerView) findViewById(R.id.card_list_view);
        card_list_view.setLayoutManager(new LinearLayoutManager(this));
        List cardItems = new ArrayList<>();
        cardItems.add("0000 8885");
        cardItems.add("0000 8886");
        cardItems.add("0000 8887");
        cardItems.add("0000 8888");
        cardItems.add("0000 8889");
        cardAdapter = new CardAdaoter(this, cardItems, R.layout.item_bankcard);
        card_list_view.addItemDecoration(new CardItemDecoration());
        card_list_view.setAdapter(cardAdapter);
//        cardAdapter.setOnItemClickListener(new ZTEBaseRecyclerAdapter.OnItetmClickListener<CardItem>() {
//            @Override
//            public void onItemClick(View view, CardItem item, int position) {
//                Intent intent = new Intent(mAty, CardInfoActivity.class);
//                intent.putExtra("data", item);
////                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////                    mAty.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(mAty, view, "cardImg").toBundle());
////                } else {
//                mAty.startActivity(intent);
////                }
//            }
//        });
    }
}
