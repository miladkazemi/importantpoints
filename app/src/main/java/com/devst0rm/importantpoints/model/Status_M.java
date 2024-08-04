package com.devst0rm.importantpoints.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status_M {
    @SerializedName("ok")
    @Expose
    private boolean ok;
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("msg")
    @Expose
    private String msg;


    public Status_M(boolean ok, int code, String msg) {
        this.ok = ok;
        this.code = code;
        this.msg = msg;
    }

    public boolean isOk() {
        return ok;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
