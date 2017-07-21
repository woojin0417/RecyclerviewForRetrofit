package com.woojin0417.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ash on 2017-07-20.
 */

public class ItemResponse {

    @SerializedName("appList")
    @Expose

    private List<Item> items;
    public List<Item> getItems()
    {
        return items;
    }
    public void setItems (List<Item>items){
        this.items=items;
    }

}
