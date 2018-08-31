package com.fdt.util;

import android.util.Log;

/**
 * Created by fudetian on 2018/8/27.
 */

public class UiUtil {
    private final static String TAG = "MYB_TAG";

    public static void logE(String log) {
        logE(TAG, log);
    }

    public static void logE(String Tag, String log) {
        if (log != null)
            if (log.length() > 3000) {
                for (int i = 0; i < log.length(); i += 3000) {
                    if (i + 3000 < log.length())
                        Log.e(Tag + i, log.substring(i, i + 3000));
                    else
                        Log.e(Tag + i, log.substring(i, log.length()));
                }
            } else
                Log.e(Tag, log);
    }

}
