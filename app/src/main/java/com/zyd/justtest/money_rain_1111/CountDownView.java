package com.zyd.justtest.money_rain_1111;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyd.justtest.R;

public class CountDownView extends LinearLayout {

    private TextView countDownText;
    private CountDownTimerHelper timerHelper;

    public CountDownView(Context context) {
        this(context, null);
    }

    public CountDownView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }

    public void initCountDownTimer(int seconds, IntConsumer callback) {
        timerHelper = new CountDownTimerHelper.Builder()
                .setTotalSeconds(seconds)
                .setOnTickCallback(value -> countDownText.setText(String.valueOf(value)))
                .setOnFinishCallback(callback)
                .build();
    }

    public void beginCountDown() {
        timerHelper.start();
    }

    public void cancelCountDown() {
        timerHelper.cancel();
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_count_down, this, true);
        countDownText = view.findViewById(R.id.count_down);
    }
}
