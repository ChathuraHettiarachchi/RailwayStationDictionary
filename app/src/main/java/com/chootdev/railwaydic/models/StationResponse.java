package com.chootdev.railwaydic.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StationResponse {

    @SerializedName("array")
    private List<StationSingle> array;

    public StationResponse() {
    }

    public StationResponse(List<StationSingle> array) {
        this.array = array;
    }

    public void setArray(List<StationSingle> array) {
        this.array = array;
    }

    public List<StationSingle> getArray() {
        return array;
    }

    @Override
    public String toString() {
        return
                "StationResponse{" +
                        "array = '" + array + '\'' +
                        "}";
    }
}