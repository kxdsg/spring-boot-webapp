package com.web.api.utils;

import com.google.gson.Gson;

/**
 * Created by xingding on 2016/10/29.
 */
public class GsonUtil {

    private static final Gson gson = new Gson();

    public static Gson getGson(){
        return gson;
    }
}
