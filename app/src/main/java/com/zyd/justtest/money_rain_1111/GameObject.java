package com.zyd.justtest.money_rain_1111;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import com.zyd.justtest.R;
import com.zyd.justtest.money_rain_1111.method.CoordinatePredicate;
import com.zyd.justtest.money_rain_1111.method.Track;

public class GameObject {

    private PointF point;
    private Paint paint;
    private CoordinatePredicate predicate;
    private Track track;


    public GameObject(float x, float y) {
        point = new PointF(x, y);
        paint = new Paint();
    }

    public PointF getPoint() {
        return point;
    }

    public void setPredicate(CoordinatePredicate predicate) {
        this.predicate = predicate;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public boolean isClicked(float x, float y, float width, float height) {
        return point.x <= x && x <= point.x + width
                && point.y <= y && y <= point.y + height;
    }

    public boolean shouldDestroy() {
        if (predicate == null) {
            return false;
        }
        return predicate.test(point);
    }

    public void drawSelf(Canvas canvas, Bitmap bitmap) {
        track.next(point);
        canvas.drawBitmap(bitmap, point.x, point.y, paint);
    }
}
