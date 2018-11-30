package com.lingtao.recyclerlibrary.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class ScreeUtils {


    public static final int getHeigh(Context context) {
//        DisplayMetrics dm = new DisplayMetrics();
//        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int screenHeigh = dm.heightPixels;
//        return screenHeigh;

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();//屏幕宽度
        int height = wm.getDefaultDisplay().getHeight();//屏幕高度
        return height;
    }

    public static final int getWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        return width;
    }
}
