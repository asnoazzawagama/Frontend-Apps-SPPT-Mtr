package com.example.pbb_mataram.ui;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendPenyampaianListModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("sppt")
    @Expose
    private List<Sppt> sppt = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Sppt> getSppt() {
        return sppt;
    }

    public void setSppt(List<Sppt> sppt) {
        this.sppt = sppt;
    }

}
