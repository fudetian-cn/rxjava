package com.fdt.agency;

import android.util.Log;

/**
 * Created by fudetian on 2018/8/3.
 */

public class BusinessAgent implements Sell{

    private Vendor mVendor;

    public BusinessAgent(Vendor mVendor) {
        this.mVendor = mVendor;
    }

    @Override
    public void sell() {
        Log.e("代理:", "before");

        mVendor.sell();

        Log.e("代理:", "after");
    }

    @Override
    public void ad() {

    }
}
