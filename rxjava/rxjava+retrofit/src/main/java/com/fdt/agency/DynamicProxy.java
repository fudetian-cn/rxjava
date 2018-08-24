package com.fdt.agency;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by fudetian on 2018/8/3.
 */

public class DynamicProxy implements InvocationHandler {

    private Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.e("中介:", "before");

        Object invoke = method.invoke(obj, args);

        Log.e("中介:", "after");

        return invoke;
    }
}
