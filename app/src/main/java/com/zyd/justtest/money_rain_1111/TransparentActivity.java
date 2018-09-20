package com.zyd.justtest.money_rain_1111;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zyd.justtest.R;

public class TransparentActivity extends Activity {

    private ViewGroup container;
    private CountDownView countDownView;
    private MoneyRainView moneyRainView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.quit).setOnClickListener(v -> finish());
        container = findViewById(R.id.container);
        initCountDownView();
    }

    private void initCountDownView() {
        countDownView = new CountDownView(this);
        container.addView(countDownView);
        countDownView.initCountDownTimer(5, value -> {
            container.removeView(countDownView);
            initMoneyRainView();
        });
        countDownView.beginCountDown();
    }

    private void initMoneyRainView() {
        moneyRainView = new MoneyRainView(this);
        moneyRainView.initCountDownTimer(20, value -> {
            moneyRainView.removeAllViews();
            Toast.makeText(this, "点了" + moneyRainView.getSum() + "个红包", Toast.LENGTH_SHORT).show();
            finish();
        });
        container.addView(moneyRainView);
        moneyRainView.beginCountDown();
    }

    @Override
    public void finish() {
        super.finish();
        if (countDownView != null) {
            countDownView.cancelCountDown();
        }
    }
}
