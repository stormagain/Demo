package com.demo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 * Created by 37X21=777 on 17/11/18.
 */

public class Alert {

    public static void alertDialog() {
        Context mAppContext = null;
        try {
            Class<?> clazz = Class.forName("android.app.ActivityThread");
            Method method = clazz.getDeclaredMethod("currentApplication", new Class[0]);
            mAppContext = (Context) method.invoke(null, new Object[0]);
        } catch (Throwable e) {
            e.printStackTrace();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(mAppContext);
        builder.setTitle("Hi").setMessage("Hello World");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();


            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        } else {
            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_PHONE);
        }
        dialog.show();
    }


    private static Handler handler;

    public static void alertAnyWhere() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            alertDialog();
        } else {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    alertDialog();
                }
            });
        }
    }


}
