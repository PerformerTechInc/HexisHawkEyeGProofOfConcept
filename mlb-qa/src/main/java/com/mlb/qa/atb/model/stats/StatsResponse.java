package com.mlb.qa.atb.model.stats;


import com.google.gson.annotations.Expose;

public class StatsResponse {

    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
