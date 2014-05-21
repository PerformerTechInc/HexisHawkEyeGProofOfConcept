package com.mlb.qa.atb.model.map;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Response {

    private static Gson gson;

    static {
        gson = new Gson();
    }


    public Response(String json){
        setData(json);
    }

    private String stadiumName;

    private Stadium stadium;

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void setData(String json) {
        Object o = gson.fromJson(json, Object.class);

        List keys = new ArrayList();
        Collection values = null;
        if (o instanceof Map) {
            Map map = (Map) o;
            keys.addAll(map.keySet());
            values = map.values();
        } else if (o instanceof Collection) {
            values = (Collection) o;
        }
        setStadiumName(keys.get(0).toString());


        Stadium stadium = null;
        for (Object obj : values) {
            stadium = gson.fromJson(gson.toJson(obj), Stadium.class);
        }
        setStadium(stadium);
    }

}