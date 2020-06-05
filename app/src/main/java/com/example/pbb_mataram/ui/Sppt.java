package com.example.pbb_mataram.ui;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sppt {

    @SerializedName("nop")
    @Expose
    private String nop;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("tahun")
    @Expose
    private String tahun;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("payment_flag")
    @Expose
    private String paymentFlag;

    public String getNop() {
        return nop;
    }

    public void setNop(String nop) {
        this.nop = nop;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaymentFlag() {
        return paymentFlag;
    }

    public void setPaymentFlag(String paymentFlag) {
        this.paymentFlag = paymentFlag;
    }

}