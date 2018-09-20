package com.zyd.justtest.money_rain_1111.method;

import android.graphics.PointF;

@FunctionalInterface
public interface CoordinatePredicate {
    boolean test(PointF point);
}
