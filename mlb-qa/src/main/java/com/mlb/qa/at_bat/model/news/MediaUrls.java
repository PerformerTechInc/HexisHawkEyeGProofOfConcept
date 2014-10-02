package com.mlb.qa.at_bat.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MediaUrls {

    @SerializedName("HTTP_CLOUD_MOBILE")
    @Expose
    private HTTPCLOUDMOBILE HTTPCLOUDMOBILE;
    @SerializedName("HTTP_CLOUD_TABLET")
    @Expose
    private HTTPCLOUDTABLET HTTPCLOUDTABLET;

    /**
     * @return The HTTPCLOUDMOBILE
     */
    public HTTPCLOUDMOBILE getHTTPCLOUDMOBILE() {
        return HTTPCLOUDMOBILE;
    }

    /**
     * @param HTTPCLOUDMOBILE The HTTP_CLOUD_MOBILE
     */
    public void setHTTPCLOUDMOBILE(HTTPCLOUDMOBILE HTTPCLOUDMOBILE) {
        this.HTTPCLOUDMOBILE = HTTPCLOUDMOBILE;
    }

    /**
     * @return The HTTPCLOUDTABLET
     */
    public HTTPCLOUDTABLET getHTTPCLOUDTABLET() {
        return HTTPCLOUDTABLET;
    }

    /**
     * @param HTTPCLOUDTABLET The HTTP_CLOUD_TABLET
     */
    public void setHTTPCLOUDTABLET(HTTPCLOUDTABLET HTTPCLOUDTABLET) {
        this.HTTPCLOUDTABLET = HTTPCLOUDTABLET;
    }


}
