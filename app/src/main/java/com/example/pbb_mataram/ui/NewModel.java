package com.example.pbb_mataram.ui;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewModel {
    @SerializedName("data")
    @Expose
    RetroModel data;

    @SerializedName("message")
    @Expose
    String message;

    @SerializedName("success")
    @Expose
    boolean success;

    public RetroModel getData() {
        return data;
    }

    public void setData(RetroModel RetroModel) {
        data = RetroModel;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
