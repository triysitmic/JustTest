package com.zyd.justtest.money_rain_1111;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class RainView extends SurfaceView implements SurfaceHolder.Callback {

    private Timer timer;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private RainManager manager;


    @SuppressLint("ClickableViewAccessibility")
    public RainView(Context context) {
        super(context);
        manager = new RainManager(context);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFormat(PixelFormat.TRANSLUCENT);
        setZOrderOnTop(true);
        setFocusable(true);
        setClickable(true);
        setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                float x = event.getX();
                float y = event.getY();
                manager.onClick(x, y);
            }
            return false;
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                canvas = surfaceHolder.lockCanvas();
                manager.recycleGameObjects();
                manager.create();
                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                manager.draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }, 0, 10);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

}
