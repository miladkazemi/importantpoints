package com.devst0rm.importantpoints.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categories_M {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("type")
    @Expose
    private String type;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public String getType() {
        return type;
    }
}
