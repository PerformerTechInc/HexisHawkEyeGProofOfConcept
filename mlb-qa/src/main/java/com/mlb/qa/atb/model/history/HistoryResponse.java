package com.mlb.qa.atb.model.history;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class HistoryResponse {

    @Expose
    private List<Response> response = new ArrayList<Response>();

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

}
