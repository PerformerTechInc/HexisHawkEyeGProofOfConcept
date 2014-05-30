package com.mlb.qa.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Administrator on 5/26/2014.
 */
public class JsonUtils {
    private static Gson gson;

    static {
        gson = new Gson();
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static String toJsonHuman(Object src) {
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        return prettyGson.toJson(src);
    }
}
