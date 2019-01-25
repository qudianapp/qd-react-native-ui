package com.qudian.ui.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * 单位转换帮助类
 */

public class QDDensityUtils {

    /**
     * dp 转 px
     *
     * @param value   如要把20dp转成px对应的数值，value传20
     * @param context
     * @return 以 {@link DisplayMetrics#density} 为3.0的设备为例，传入20将返回20*3.0=60
     */
    public static float dp2pxFloat(Context context, float value) {
        if (context == null) {
            return value;
        }
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    /**
     * dp 转 px 并把结果转成int型
     */
    public static int dp2px(Context context, float value) {
        if (context == null) {
            return (int) value;
        }
        return (int) (dp2pxFloat(context, value) + 0.5);
    }

    public static float sp2pxFloat(Context context, float value) {
        if (context == null) {
            return value;
        }
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, context.getResources().getDisplayMetrics());
    }

    /**
     * sp 转 px
     *
     * @param value   如要把20sp转成px对应的数值，value传20
     * @param context
     * @return 以 {@link DisplayMetrics#scaledDensity} 为3.0的设备为例，传入20将返回20*3.0=60。scaledDensity一般和density相等
     */
    public static float sp2px(Context context, float value) {
        if (context == null) {
            return value;
        }
        return (int) (sp2pxFloat(context, value) + 0.5);
    }

    /**
     * @param value   像素值，如60px
     * @param context
     * @return dp值
     */
    public static float px2dpFloat(Context context, float value) {
        if (context == null) {
            return value;
        }
        //1dp=多少px,density=3此值为3
        float pxPerDp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, context.getResources().getDisplayMetrics());

        if (pxPerDp == 0) {//只为容错：防止除0异常
            return value;
        }
        //1px=多少dp，density=3此值为1/3
        float dpPerPx = 1 / pxPerDp;
        return dpPerPx * value;
    }

    public static int px2dp(Context context, float value) {
        if (context == null) {
            return (int) value;
        }
        return (int) (px2dpFloat(context, value) + 0.5);
    }

    public static float px2spFloat(Context context, float value) {
        if (context == null) {
            return value;
        }
        //1sp=多少px
        float pxPerSp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 1, context.getResources().getDisplayMetrics());

        if (pxPerSp == 0) {//只为容错：防止除0异常
            return value;
        }
        //1px=多少sp
        float spPerPx = 1 / pxPerSp;
        return spPerPx * value;
    }

    public static int px2sp(Context context, float value) {
        if (context == null) {
            return (int) value;
        }
        return (int) (px2spFloat(context, value) + 0.5);
    }


}
