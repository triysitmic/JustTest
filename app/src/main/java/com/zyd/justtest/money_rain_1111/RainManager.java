package com.zyd.justtest.money_rain_1111;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;

import com.zyd.justtest.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RainManager {
    private static int MAX_SUM_PER_LINE = 5;
    private static int INTERNAL = 150;
    private List<GameObject> gameObjects;

    private Bitmap bitmap;

    public RainManager(Context context) {
        this.gameObjects = new ArrayList<>();
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
    }

    public synchronized void create() {
        if (gameObjects.size() <= 0) {
            createObject();
        }
        PointF point = gameObjects.get(gameObjects.size() - 1).getPoint();
        if (point.y > 500) {
            createObject();
        }
    }

    public synchronized void draw(Canvas canvas) {
        for (GameObject gameObject : gameObjects) {
            gameObject.drawSelf(canvas, bitmap);
        }
    }

    public synchronized void onClick(float x, float y) {
        if (gameObjects == null || gameObjects.size() <= 0) {
            return;
        }
        Iterator iterator = gameObjects.iterator();
        while (iterator.hasNext()) {
            GameObject object = (GameObject) iterator.next();
            if (object.isClicked(x, y, bitmap.getWidth(), bitmap.getHeight())) {
                iterator.remove();
            }
        }
    }

    public synchronized void recycleGameObjects() {
        if (gameObjects == null || gameObjects.size() <= 0) {
            return;
        }
        Iterator iterator = gameObjects.iterator();
        while (iterator.hasNext()) {
            GameObject object = (GameObject) iterator.next();
            if (object.shouldDestroy()) {
                iterator.remove();
            }
        }
    }

    private void createObject() {
        for (int i = 0; i < MAX_SUM_PER_LINE; i++) {
            GameObject gameObject = new GameObject(i * INTERNAL, 0);
            gameObject.setPredicate(point -> point.y >= 1920);
            gameObject.setTrack(point -> point.y += 10);
            gameObjects.add(gameObject);
        }
    }
}
