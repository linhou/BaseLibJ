package com.xy.baselib.conversion;

import android.text.TextUtils;

public class SafetyType {

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException("这个对象是空的:"+reference);
        } else {
            return reference;
        }
    }
    public static int parseInt(String s){
        if (TextUtils.isEmpty(s)){
            throw new NullPointerException("parseInt 字符串:"+s);
        }else {
            return Integer.parseInt(s);
        }
    }

    public static double parseDouble(String s){
        if (TextUtils.isEmpty(s)){
            throw new NullPointerException("parseDouble 字符串:"+s);
        }else {
            return Double.parseDouble(s);
        }
    }
}
