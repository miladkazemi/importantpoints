package com.devst0rm.importantpoints.remote.APIService.point;

import com.devst0rm.importantpoints.model.Points_M;
import com.devst0rm.importantpoints.model.Status_M;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PointListRes_M {

    @SerializedName("data")
    @Expose
    private ArrayList<Points_M> data;

    @SerializedName("status")
    @Expose
    private Status_M status;


    public ArrayList<Points_M> getData() {
        return data;
    }

    public Status_M getStatus() {
        return status;
    }
}