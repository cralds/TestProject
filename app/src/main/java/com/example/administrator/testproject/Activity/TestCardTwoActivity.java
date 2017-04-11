package com.example.administrator.testproject.Activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.testproject.R;
import com.example.administrator.testproject.adapter.TestStackAdapter;
import com.rey.material.widget.LinearLayout;
import com.test.view.card.CardStackView;

import java.util.Arrays;

public class TestCardTwoActivity extends AppCompatActivity implements CardStackView.ItemExpendListener {

    public static Integer[] TEST_DATAS = new Integer[]{
            R.color.color_1,
            R.color.color_2,
            R.color.color_3,
            R.color.color_4,
            R.color.color_5,
            R.color.color_6,
            R.color.color_7,
            R.color.color_8,
            R.color.color_9,
            R.color.color_10,
            R.color.color_11,
            R.color.color_12,
            R.color.color_13,
            R.color.color_14,
            R.color.color_15,
            R.color.color_16,
            R.color.color_17,
            R.color.color_18,
            R.color.color_19,
            R.color.color_20,
            R.color.color_21,
            R.color.color_22,
            R.color.color_23,
            R.color.color_24,
            R.color.color_25,
            R.color.color_26
    };
    private LinearLayout mActionButtonContainer;
    private TestStackAdapter mTestStackAdapter;

    private CardStackView cardStackView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_cardtwo);

        cardStackView = (CardStackView) findViewById(R.id.cardstactView);
//        mActionButtonContainer = (LinearLayout) findViewById(R.id.button_container);
        cardStackView.setItemExpendListener(this);
        mTestStackAdapter = new TestStackAdapter(this);
        cardStackView.setAdapter(mTestStackAdapter);

        mTestStackAdapter.updateData(Arrays.asList(TEST_DATAS));
    }

    @Override
    public void onItemExpend(boolean expend) {

    }
}
