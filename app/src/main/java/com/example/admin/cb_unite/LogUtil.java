package com.example.admin.cb_unite;

import android.util.Log;

public class LogUtil {
    public static void info(Object o, String message){
        Log.d(o.getClass().getName(), message);
    }
}
