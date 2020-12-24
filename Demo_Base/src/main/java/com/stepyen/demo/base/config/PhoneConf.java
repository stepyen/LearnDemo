package com.stepyen.demo.base.config;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;


/**
 * @author LYB
 * @time 17/10/27 下午3:42
 * @des 手机参数
 */

public class PhoneConf {

    private final static int HEIGHT = 1920, WIDTH = 1080;
    private final static float PHONERATIO = HEIGHT * 1f / WIDTH;
    private int width, height; // 手机的宽高
    private int standardWidth, standardHeight; // 基于标准宽高比(9:16)的宽高
    private int marginLR, marginTB; // 基于标准宽高比的边距
    private int widthUnit, heightUnit; // 手机宽高所占单元
    private int marginLRUnit, marginTBUint; //边距所占单元
    private float unitSize; // 一个单元的大小
    private float textPxUnit; //
    private float ratio; //

    private float density;


    public PhoneConf(Context context) {
        countHighWidth(context);
        countUnits();
    }

    private void countHighWidth(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            DisplayMetrics metric = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRealMetrics(metric);

            height = metric.heightPixels;
            width = metric.widthPixels;
            density = metric.density;
        } else {
            Point p = new Point();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(p);

            height = p.y;
            width = p.x;
            density = context.getResources().getDisplayMetrics().density;
        }

        if (height < width) {
            int temp = height;
            height = width;
            width = temp;
        }

        // 修复华为挖孔屏bug（竖屏获取高度不包括挖空高度，横屏则包括）
//        int ns = App.get().isScreenVertical ? getNotchSize(context)[1] : 0;
//        int ns = NotchScreenUtil.getNotchSizeAtHuawei(context);
//        height = height + ns;

        ratio = height * 1f / width;


    }

    private void countUnits() {
        unitSize = Math.min(height * 1f / HEIGHT, width * 1f / WIDTH);
        textPxUnit = unitSize * 3;
        standardWidth = (int) (unitSize * WIDTH);
        standardHeight = (int) (unitSize * HEIGHT);
        marginTB = (height - standardHeight) >> 1;
        marginLR = (width - standardWidth) >> 1;
        heightUnit = (int) ((height + .5f) / unitSize);
        widthUnit = (int) ((width + .5f) / unitSize);
        marginLRUnit = (widthUnit - WIDTH) >> 1;
        marginTBUint = (heightUnit - HEIGHT) >> 1;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public int getStandardWidth() {
        return standardWidth;
    }

    public int getStandardHeight() {
        return standardHeight;
    }

    public int getMarginLR() {
        return marginLR;
    }

    public int getMarginTB() {
        return marginTB;
    }

    public int getWidthUnit() {
        return widthUnit;
    }

    public int getHeightUnit() {
        return heightUnit;
    }

    public int getMarginLRUnit() {
        return marginLRUnit;
    }

    public int getMarginTBUnit() {
        return marginTBUint;
    }

    public float getUnitSize() {
        return unitSize;
    }

    public float getTextPxUnit() {
        return textPxUnit;
    }

    public float getRatio() {
        return ratio;
    }

    public float getPhoneratio() {
        return PHONERATIO;
    }
}
