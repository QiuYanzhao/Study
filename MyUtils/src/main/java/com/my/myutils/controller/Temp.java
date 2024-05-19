package com.my.myutils.controller;

import com.alibaba.fastjson2.JSONObject;

public class Temp {

    public static void main(String[] args) {
        Integer code = 1;

        String cacheKey = String.format("%s_%s", code, "dfasd");
        System.err.println(cacheKey);
    }


}
