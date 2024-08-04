package com.devst0rm.importantpoints.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Points_M {

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
    @SerializedName("categoryType")
    @Expose
    private String categoryType;
    @SerializedName("open")
    @Expose
    private int isOpen;


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

    public String getCategoryType() {
        return categoryType;
    }

    public int isOpen() {
        return isOpen;
    }
}
