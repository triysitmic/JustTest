package com.zyd.justtest.money_rain_1111;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyd.justtest.R;

import java.util.ArrayList;
import java.util.List;

public class MoneyRainView extends RelativeLayout {

    private List<ObjectAnimator> animators = new ArrayList<>();

    private CountDownTimerHelper timerHelper;

    private TextView countDownView;
    private TextView sumView;

    private int sum = 0;

    public MoneyRainView(Context context) {
        this(context, null);
    }

    public MoneyRainView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoneyRainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initCountDownTimer(int seconds, IntConsumer callback) {
        timerHelper = new CountDownTimerHelper.Builder()
                .setOnFinishCallback(callback)
                .setOnTickCallback(value -> {
                    Log.d("tag", value + "");
                    addAnimator();
                    countDownView.setText(String.format(getResources().getString(R.string.money_rain_count_down), value));
                })
                .setTotalSeconds(seconds)
                .build();
    }

    public void beginCountDown() {
        timerHelper.start();
    }

    public void finish() {
        cancelCountDown();
    }

    public int getSum() {
        return sum;
    }

    private void addAnimator() {
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.drawable.money);
            imageView.setOnClickListener(v -> {
                imageView.setVisibility(GONE);
                sum++;
                sumView.setText(String.valueOf(sum));
            });
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 150 * (i + 1);
            params.width = 150;
            params.height = 150;
            imageView.setLayoutParams(params);
            addView(imageView);

            ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY", 1920f);
            animator.setDuration(3000);
            animator.setInterpolator(new AccelerateInterpolator());
            animator.start();
        }
    }

    private void cancelCountDown() {
        timerHelper.cancel();
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_money_rain, this, true);
        countDownView = findViewById(R.id.count_down);
        sumView = findViewById(R.id.sum);
        sumView.setText(String.valueOf(sum));
    }
}
