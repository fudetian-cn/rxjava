package com.fdt.agency;

import android.util.Log;

/**
 * Created by fudetian on 2018/8/3.
 */

public class Vendor implements Sell {

    public void sell() {
        Log.e("Vendor:", "sell");
    }

    public void ad() {
        Log.e("Vendor:", "ad");
    }
}
