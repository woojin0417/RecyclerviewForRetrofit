package com.woojin0417.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ash on 2017-07-20.
 */

public class Item {

    @SerializedName("rank")
    @Expose
    private String rank;

    @SerializedName("Nm")
    @Expose
    private String Nm;

    @SerializedName("url")
    @Expose
    private String url;

    public Item(String rank, String Nm, String url)
    {
        this.rank=rank;
        this.Nm=Nm;
        this.url=url;

    }
    public String getRank()
    {
        return rank;
    }
    public void setRank(String rank)
    {
        this.rank=rank;
    }
    public String getNm()
    {
        return Nm;
    }
    public void setNm(String Nm)
    {
        this.Nm=Nm;
    }
    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url=url;
    }


}
