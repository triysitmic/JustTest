package com.zyd.justtest.money_rain_1111;

import android.os.CountDownTimer;

public class CountDownTimerHelper {

    private CountDownTimer mCountDownTimer;

    private CountDownTimerHelper() {
    }

    public void start() {
        if (mCountDownTimer != null) {
            mCountDownTimer.start();
        }
    }

    public void cancel() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    public static class Builder {

        private int mTotalSeconds;
        private IntConsumer mOnFinishCallback;
        private IntConsumer mOnTickCallback;

        public Builder setTotalSeconds(int seconds) {
            mTotalSeconds = seconds;
            return this;
        }

        public Builder setOnFinishCallback(IntConsumer consumer) {
            mOnFinishCallback = consumer;
            return this;
        }

        public Builder setOnTickCallback(IntConsumer consumer) {
            mOnTickCallback = consumer;
            return this;
        }

        public CountDownTimerHelper build() {
            CountDownTimerHelper helper = new CountDownTimerHelper();
            helper.mCountDownTimer = new CountDownTimer(mTotalSeconds * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    if (mOnTickCallback != null) {
                        mOnTickCallback.accept((int) (millisUntilFinished / 1000));
                    }
                }

                @Override
                public void onFinish() {
                    if (mOnFinishCallback != null) {
                        mOnFinishCallback.accept(0);
                    }
                }
            };
            return helper;
        }
    }
}
